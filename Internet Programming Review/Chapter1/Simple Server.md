```java
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;

public class Server{
    public static void main(String[] args)throws IOException {
        // WATING SOCKET
        ServerSocket waitSocketConnection = new ServerSocket(9999);
        System.out.println("Server started");
        // WAITING SOCKET ACCEPT NEW CONNECTION FROM CLIENT AND PASS IT TO ANOTHER SOCKET TO PROCESS THE CLIENT REQUEST

        Socket socketAtServer = waitSocketConnection.accept();
        System.out.println("Server Accepted Connection from Client");
        InputStream in = socketAtServer.getInputStream();
        OutputStream out = socketAtServer.getOutputStream();

        byte[] bufer = new byte[1024];
        in.read(buffer);
        System.out.println("Received from client." + new String(buffer).trim());
        out.write("Hello from server...".getBytes());
        System.out.println("Server message Sent");
        socketAtServer.close();
        waitSocketConnection.close();
    }
}
```
