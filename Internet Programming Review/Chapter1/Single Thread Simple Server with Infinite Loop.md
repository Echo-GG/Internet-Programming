# Single Thread Simple Server with Infinite Loop

It can only handle one client at a time and will loop after completing the task of the current client.

```java
import java.io.*;
import java.net.*;
public class static void main(String[] args)throws IOException{
    ServerSocket waitSocketConnection = new ServerSocket(9999);
    System.out.println("Server started on port 9999");
    System.out.println("Waiting for connections indefinitely...");
    // Loop indefinitely to accept multiple clients
    while(true){
        System.out.println("\n--- Waiting for client connection ---");
        Socket socketAtServer = waitSocketConnection.accept();
        System.out.println("Server Accepted Connection from Client: " + socketAtServer.getInetAddress().getHostAddress());
        // Handle the client
        InputStream in = socketAtServer.getInputStream();
        OutputStream out = socketAtServer.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        if(bytesRead > 0){
            String receivedMessage = new String (buffer,0,bytesRead).trim();
            System.out.println("Received from client: " + receivedMessage);
            out.write("Hello from server...".getBytes());
            out.flush(); // Ensure data is sent
            System.out.println("Server message Sent.");
            //Close client connection but keep server running
            socketAtServer.close();
            System.out.println("Client connection closed. Waiting for next client...");
        }
        waitSocketConnection.close(); // This line will never be reached in this implementation since this is an infinite loop.
    }
}

```
