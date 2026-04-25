# TCP Client Program

```java
import java.net.InetAddress;
import java.net.Socket;
import java.io.IOException;

public class SocketExample{
    public static void main(String[] args){
        try{
            //Remote server details
            String remoteHost = "example.com";
            int remotePort = 80;
            // Local address and port to bind to
            InetAddress localAddress = InetAddress.getByName("192.168.1.100");
            int localPort = 5000;
            // Create a socket
            Socket socket = new Socket(remoteHost,remotePort,localAddress,localPort);// localAddress i.e. InetAddress.
            System.out.println("Socket connected to " + remoteHost + ":" + remotePort);
            System.out.println("Bound to local address " + localAddress.getHostAddress() + ":" + localPort);
            // Close the socket
            socket.close();
        }catch(IOException e){
            System.out.println("Error creating socket:" + e.getMessage());
        }
    }
}

```
