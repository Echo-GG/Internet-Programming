# Example of Combining Sink and Processing Stream

```java
public class StreamExample{
    public static void main(String[] args){
        try(
            // Data Sink Stream: FileOutputStream writes BYTES into the file
            FileOutputStream fileOut = new FileOutputStream("output.txt");

            // Processing Stream: BufferedOutputStream adds buffering
            BufferedOutputStream bufferedOut = new BufferedOutputStream (fileOut);

            // Processing Stream: DataOutputStream writes primitive data types
            DataOutputStream dataOut = new DataOutputStream(bufferedOut);
        ){
            // Write data to the file
            dataOut.writeInt(123);
            dataOut.writeUTF("Hello, World!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```
