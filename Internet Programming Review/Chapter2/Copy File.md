# Copy File

## Copy File: FileReader and FileWriter without buffering

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public static void main(String[] args){
    // Paths for the source and destination files
    String sourceFilePath = "source.txt";
    String destinationFilePath = "destination.txt";

    // Use try-with-resources to automatically close the readers and writers
    try(FileReader reader = new FileReader(sourceFilePath); FileWriter writer = new FileWriter(destinationFilePath)){
        int character;

        // Read characters from the source file and write to the destination file
        while((character = reader.read())!=-1){
            writer.write(character);
            System.out.println("File copied successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```

## Improved Version Using BufferedReader and BufferedWriter

```java
//Buffering reduces the number of I/O operations, making it faster for large files.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CopyTextFileBuffered{
    public static void main(String[] args){
        // Paths for the source and destination files:
        String soucePathFile = "source.txt";
        String destinationPathFile = "destination.txt";

        // Use try-with-resources to automatically close the readers and writers
        try(BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))){
            String line;
            // Read lines from the source file and write to the destination file
            while((line = reader.readLine())!=null){
                writer.write(line);
                writer.newLine(); // Add a new line after each line
            }
            System.out.println("File copied successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```

## Copy File: File Input and Output stream without buffering

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTextFileUsingStreams{
    public static void main(String[] args){
        // Paths for the source and destination files
        String sourceFilePath = "source.txt";
        String destinationPath = "destination.txt";

        // Use try-with-resources to automatically close the streams
        try(FileInputStream fis = new FileInputStream(sourceFilePath); FileOutputStream fos = new FileOutputStream(destinationFilePath)){
            int byteData;
            // Read bytes from the source file and write to the destination file
            while((byteData = fis.read())!=-1){
                fos.write(byteData);
            }
            System.out.println("File copied successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}

```

## Improved Version of previous example by Using a Byte Array for Better Performance

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyTextFileUsingStreamsBuffered{
    public static void main(String[] args){
        // Paths for the source and destination files
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        // Use try-with-resources to automatically close the streams
        try(FileInputStream fis = new FileInputStream(sourceFilePath); FileOutputStream fos = new FileOutputStream(destiantionFilePath)){
            // Buffer to read and write data in chunks
            byte[] buffer = new byte[1024]; // 1KB buffer
            int bytesRead;

            // Read chunks of data from the source
            // file and write to the destination file
            while((bytesRead = fis.read(buffer))!=-1){
                fos.write(buffer,0,bytesRead);
                System.out.println("File copied successfully!");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}

```

1. A buffer of size 1024 bytes (1 KB) is used to read and write data in chunks reduces the number of I/O operations, making it faster for large files.

2. The read(byte[] buffer) method reads up to buffer.length bytes from the file and returns the number of bytes read.

3. The write(byte[] buffer, int offset, int length) method writes length bytes from the buffer to the file.
