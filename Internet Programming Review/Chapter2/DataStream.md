# DataStream

### In Java, DataOutputStream / DataInputStream is a class in the java.io package that allows you to write/Read primitive data types (e.g., int, double, bool, etc.) and strings to an output stream in a machine-independent way.

### It is often used in conjunction with FileOutputStream / FileInputStream or other output / input streams to write/read data to files or network sockets.

### It provides methods like writeInt() / readInt(), writeDouble() / readDouble(), writeBoolean() / readBoolean, etc., to write / read primitive data types.

### Buffered Output / Input: It can be wrapped around a BufferedOutputStream / BufferedInputStream for better performance.

## Examples

### OutputStream

```java
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class DataOutputStreamExample{
    public static void main(String[] args){
        // File path to write data
        String filePath = "output.dat";
        try(FileOutputStream fos = new FileOutputStream(filePath); BufferedOutputStream bos = new BufferedOutputStream(fos); DataOutputStream dos = new DataOutputStream(bos)){

            // Writing primitive data types to the file
            dos.writeInt(123); // Write an integer
            dos.writeDouble(123.45); // Write a double
            dos.writeBoolean(true); // Write a boolean
            dos.writeUTF("Hello, World!"); // Writing a string in UTF-8 format

            System.out.println("Data has been written to " + filePath);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```

### InputStream

```java
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class DataInputStreamExample{
    public static void main(String[] args){
        // File path to read data
        String filePath = "output.dat";
        try(FileInputStream fis = new FileInputStream(filePath); BufferedInputStream bis= new BufferedInputStream(fis); DataInputStream dis = new DataInputStream(bis)){

            // Reading data in the same order it was written
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String stringValue = dis.readUTF();

            // Displaying the read data
            System.out.println("Read int:" + intValue);
            System.out.println("Read double:" + doubleValue);
            System.out.println("Read boolean:" + booleanValue);
            System.out.println("Read string:" + stringValue);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```
