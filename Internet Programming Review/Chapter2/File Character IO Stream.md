# File Character IO Stream

### FileReader and FileWriter: This stream is used for reading and writing character-based data (text) from/to files and are designed for handling text files and work with character streams.

### For better performance, wrap FileReader and FileWriter with BufferedReader and BufferedWriter:

### BufferedReader br = new BufferedReader(new FileReader("file.txt"));

### BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));

## Examples

### Writer

```java
import java.io.FileWriter;
import java.io.IOException;
public class FileWriterExample{
    public static void main(String[] args){
        // File path to write data
        String filePath = "output.txt";

        try(FileWriter writer = new FileWriter(filePath)){
            // Writing text to the file
            writer.write("Hello,World!\n");
            writer.write("This is a test file.\n");
            writer.write("Using FileWriter in Java.\n");

            System.out.println("Data has been written to " + filePath);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```

### Reader

```java
import java.io.FileReader;
import java.io.IOException;
public class FileReaderExample{
    public static void main(String[] args){
        // File path to read data
        String filePath = "output.txt";

        try(FileReader reader = new FileReader(filePath)){
            int character;
            // Reading characters one by one
            while(character = reader.read()!=-1){
                System.out.print((char) character);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

```

---

### EOF Detection

Detecting the end of a file (EOF):

Usually amount of data to be read is not known

Reading methods return ‘impossible‘ value if end of file is reached

Example:

FileReader.read returns -1

BufferedReader.readLine() returns ‘null‘

Typical code for EOF detection:

```java
    while (c = myReader.read() != -1){	 // read and check c
        //...do something with c
    }
```
