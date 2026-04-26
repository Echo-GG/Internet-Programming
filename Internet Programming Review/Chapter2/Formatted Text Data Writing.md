# Formatted Text Data Writing

## PrintWriter is a class that provides methods to write formatted text data to an output stream (e.g., a file, console, or network socket).

## It is similar to System.out, but it can write to any output stream.

## Formatted Output: Provides methods like print(), println(), printf(), etc., for writing formatted text.

## Auto-Flush: Can automatically flush the stream after every write operation if enabled.

## No IOException: Unlike other I/O classes, PrintWriter methods do not throw IOException. Instead, you can check for errors using the checkError() method.

## Wraps Other Streams: Can wrap other output streams like FileOutputStream, OutputStreamWriter, etc.

```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class PrintWriterExample{
    public static void main(String[] args){
        // File path to write data
        String filePath = "output.txt";
        try(FileWriter fw = new FileWriter(filePath); PrintWriter pw = new PrintWriter(fw)){

            // Writing formatted data to the file
            pw.println("Hello, PrintWriter!\n");
            pw.printf("Formatted number: %d%n",123);
            pw.printf("Formatted double: %.2f%n",123.456);
            pw.printf("Formatted boolean: %b%n",true);

            System.out.println("Data has been written to" + filePath);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

// NOTE: However, there is no PrintReader class in Java. Instead, BufferedReader is typically used for reading text data.

```
