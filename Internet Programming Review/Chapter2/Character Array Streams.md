# Character Array Streams

## Using character arrays as stream sources and destinations

## In Java, CharArrayReader and CharArrayWriter are I/O classes that handle character array (char[]) input and output streams.

## They are part of the java.io package and are useful for in-memory stream operations without involving physical files or network resources.

1. CharArrayReader (Input from char[]): CharArrayReader reads characters from a char[] array as an input stream. It extends Reader and provides methods to read characters sequentially.

**Key Features:**

##### Reads from an in-memory char[] array.

##### Supports mark() and reset() for re-reading data.

##### Lightweight alternative to FileReader when working with character arrays.

## Example

```java
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOExcepion;

public class CharArrayIOExample{
    public static void main(String[] args){
        // ===== 1. CharArrayWriter (Write to a char[]) =====
        CharArrayWriter writer = new CharArrayWriter();

        // Write data to the in-memory buffer
        writer.write("Hello ");
        writer.write(new char[]{'J','a','v','a','!'});

        // Get the written data as a char[] and String
        char[] writtenData = writer.toCharArray();
        String writtenString = writer.toString();

        System.out.println("Written char[]:" + new String(writtenData)); // "Hello Java!"
        System.out.println("Written String:" + writtenString);
        // "Hello Java!"

        // ===== 2. CharArrayReader (Read from a char[]) =====
        CharArrayReader reader = new CharArrayReader(writtenData);
        try{
            System.out.print("Read from char[]:");
            int ch;
            while((ch = reader.read())!=-1){
                System.out.print((char) ch);
                // Prints "Hello Java!"
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            reader.close();
            // Explicitly close (or use try-with-resources)
        }

    }
}
```
