# Memory-Mapped I/O for Large File Processing in Java

1. Memory-mapped I/O is a powerful technique for efficiently processing large files by mapping file contents directly into memory.

2. Let us see How Memory-Mapping Works

3. Concept: Instead of reading/writing files through traditional I/O operations, the file is mapped to a region of virtual memory

4. Mechanism: The operating system handles loading/unloading file chunks as needed

5. Benefits:

   (i). Avoids costly read()/write() system calls

   (ii). Enables random access to file contents

   (iii). Can dramatically improve performance for large files

6. Implementation by Using FileChannel

## Example

```java
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFileReader{
    public static void main(String[] args)throws Exception{
        String filePath = "large_file.dat";
        long fileSize = 1024*1024*1024; // 1 GB file

        try(RandomAccessFile file = new RandomAccessFile(filePath,"rw"); FileChannel channel = file.getChannel()){
            // Map the entire file into memory
            MappedByteBuffer buffer = channel.map(
                FileChannel.MapMode.READ_WRITE, // Access mode
                0, // Starting position
                fileSize // Size to map
            );

            // Process the buffer
            while(buffer.hasRemaining()){
                byte b = buffer.get();
                // Process each byte
            }
        }
    }
}
```

### Key Components

**FileChannel: Provides the mapping capability**

**Map Modes:**

1. READ_ONLY: Read-only mapping

2. READ_WRITE: Read/write mapping (changes written back to file)

3. PRIVATE: Copy-on-write (changes not written to file)

4. MappedByteBuffer: Acts like a direct memory array of the file contents

## Processing Large Files in Chunks

**For very large files (larger than 2 GB), map portions sequentially:**

```java
final long CHUNK_SIZE = 1024*1024*1024; // 100 MB chunks
long position = 0;
while(position < fileSize){
    long remaining = fileSize - position;
    long chunkSize = Math.min(CHUNK_SIZE,remaining);

    MappedByteBuffer chunk = channel.map(
        FileChannel.MapMode.READ_ONLY,
        position,
        chunkSize
    );

    processChunk(chunk);
    position += chunkSize;
}
```

## Advanced Example (Search in Large File)

```java
public boolean searchInLargeFile(Path file,byte[] pattern) throws IOException{
    try(FileChannel channel = FileChannel.open(file,StandardOpenOption.READ)){
        long fileSize = channel.size();
        long position = 0;

        while(position < fileSize){
            long remaining = fileSize - position;
            long chunkSize = Math.min(256*1024*1024,remaining); // 256 MB chunks

            MappedByteBuffer buffer = channel.map(
                FileChannel.MapMode.READ_ONLY,
                position,
                chunkSize
            );

            if(findPattern(buffer,pattern)){
                return true;
            }

            position += chunkSize - (pattern.length - 1);
        }
    }
    return false;
}

private boolean findPattern(MappedByteBuffer buffer,byte[] pattern){
    // Boyer-Moore or other efficient search algorithm
    // ...
}
```
