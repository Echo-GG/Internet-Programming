# DataInputStream and DataOutputStream for Structured Data

## Advantages:

1. Primitive Data Type Support: methods like readInt(), readDouble(), writeInt(), writeDouble(), etc., to read and write primitive data types in a machine-independent way. Use this when you need to read or write structured data (e.g., a file containing a mix of integers, doubles, and strings).

2. String Support: writing strings in UTF-8 format using readUTF() and writeUTF().

3. Flexibility: They can be used to read and write structured data (e.g. a file containing integers, doubles, and strings).

4. Buffering: When combined with BufferedInputStream and BufferedOutputStream, they can provide efficient I/O operations.

5. For simple file copying, FileInputStream and FileOutputStream (or BufferedInputStream and BufferedOutputStream) are more appropriate.

### Writing Structured Data

```java
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class WriteStructuredData{
    public static void main(String[] args){
        try(FileOutputStream fos = new FileOutputStream("data.bin"); DataOutputStream dos = new DataOutputStream(fos)){
            // Write structured data
            dos.writeInt(123); // Write an integer
            dos.writeDouble(123.45); // Write a double
            dos.writeUTF("Hello"); // Write a string
            System.out.println("Data written successfully!");
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}

```

### Reading Structured Data

```java
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadStructuredData{
    public static void main(String[] args){
        try(FileInputStream fis = new FileInputStream("data.bin"); DataInputStream dis = new DataInputStream(fis)){
            // Read structured data in the same order it was written
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            String stringValue = dis.readUTF();

            // Display the data
            System.out.println("Read int: " + intValue);
            System.out.println("Read double: " + doubleValue);
            System.out.println("Read string: " + stringValue);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

```
