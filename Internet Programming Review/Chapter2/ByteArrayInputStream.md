# ByteArrayInputStream

## ByteArrayInputStream allows reading bytes from a byte array as if it were an input stream.

## It is useful when you need to treat an in-memory byte array as a stream for reading purposes.

## Key Features of ByteArrayInputStream:

1. Reads data from a byte array (instead of a file or network).
2. Does not require an external resource (like files or sockets), making it lightweight.
3. Supports stream-based operations (e.g., read(), skip(), mark(), reset()).
4. Does not close any system resources (since it operates on an in-memory array).

## Common Use Cases:

1. Converting byte arrays into an InputStream (for APIs that expect an InputStream).
2. Parsing binary data stored in memory.
3. Testing (mocking an InputStream without actual files).
4. Processing data from a byte source (e.g., serialized objects, image data).

## Byte input stream: ByteArrayInputStream

## Byte output stream: ByteArrayOutputStream

## Use byte arrays as the source and destination of a stream respectively

## Using byte arrays as stream sources and destinations

## Example

```java
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExample{
    public static void main(String[] args){
        byte[] byteArray = {72,101,108,108,111,32,87,111,114,108,100};
        // "Hello World" in ASCII

        try(ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)){
            int data;
            while((data = bais.read())!=-1){
                System.out.print((char) data);
                // Converts byte to char
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
```

**ByteArrayInputStream is a convenient way to treat a byte array as a stream, enabling compatibility with Java’s stream-based APIs while avoiding I/O overhead. It’s widely used in scenarios where data is already available in memory.**

## Key Methods

| Method                          | Description                    |
| ------------------------------- | ------------------------------ |
| read()                          | Reads a single byte            |
| read(byte[] b,int off, int len) | Reads bytes into an array      |
| skip(long n)                    | Skips n bytes                  |
| available()                     | Returns remaining bytes        |
| mark(int readlimit)             | Marks current position         |
| reset()                         | Returns to the marked position |
