# ByteArrayOutputStream

## Allows writing bytes into an expandable in-memory byte array. It is useful when you need to collect data dynamically in a byte array before converting it into a usable form (e.g., a String, file, or network transmission).

## Key Features of ByteArrayOutputStream:

1. Writes data to an in-memory byte array (instead of a file or network).
2. Automatically grows as more data is written (unlike a fixed-size array).
3. Provides stream-based operations (write(), toByteArray(), toString()).
4. Does not require closing (since it operates purely in memory).

## Common Use Cases:

1. Building a byte array dynamically (e.g., when the final size is unknown).
2. Converting multiple writes into a single byte array (e.g., serialization, network buffers).
3. Generating String data from bytes (using toString()).
4. Testing (mocking an OutputStream without writing to files).

```java
import java.io.ByteArrayOutputStream;
import java.io.IOException;
public class ByteArrayOutputStreamExample{
    public static void main(String[] args){

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            baos.write(72); // 'H' in ASCII
            baos.write(101); // 'e'
            baos.write(108); // 'l'
            baos.write(108); // 'l'
            baos.write(111); // 'o'
            byte[] byteArray = baos.toByteArray();
            System.out.println(new String(byteArray)); // "Hello"
        } catch(IOException e){
            throw new RuntimeException(e);
        }

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            baos.write("Hello, ".getBytes());
            baos.write("World!".getBytes());
            String result = baos.toString(); // "Hello, World!"
            System.out.println(result);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
```

**ByteArrayOutputStream is a powerful tool for efficiently collecting bytes in memory before converting them into a byte[], String, or passing them to another stream. It is widely used in scenarios like: Serialization (e.g., converting objects to bytes), Network programming (building packets before sending), Data processing (e.g., reading from multiple sources into one buffer).**

| Method                           | Description                                                |
| -------------------------------- | ---------------------------------------------------------- |
| write(int b)                     | Writes a single byte.                                      |
| write(byte[]b, int off, int len) | Writes a portion of a byte array.                          |
| toByteArray()                    | Returns the accumulated bytes as a byte[].                 |
| toString()                       | Converts the buffer into a String (using default charset). |
| toString(String charsetName)     | Converts using a specified charset (e.g. "UTF-8").         |
| reset()                          | Clears the buffer (reuses the same buffer).                |
| size()                           | Returns the current number of bytes written.               |

## Example

```java
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
public class ByteArrayStreamsExample{
    public static void main(String[] args){
        // Original data (as bytes)
        String originalData = "Hello,Java Streams!";
        byte[] inputBytes = originalData.getBytes();

        // 1. Read data using ByteArrayInputStream
        try(ByteArrayInputStream bais = new ByteArrayInputStream(inputBytes); ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            // 2. Copy data from input stream to output stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = bais.read(inputBytes))!=-1){
                baos.write(buffer,0,bytesRead);
            }
            // 3. Get the result as a byte array and print it
            byte[] outputBytes = baos.toByteArray();
            System.out.println("Original Data:" + originalData);
            System.out.println("Copied Data:" + baos.toString());
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
```
