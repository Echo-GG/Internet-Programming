# TCPClient

```java
import java.io.OutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
public class Client{
    public static void main(String[] args)throws IOException{
        Socket clientSock = new Socket("127.0.0.1",9999);
        System.out.println("connected to server..");

        InputStream in = clientSock.getInputStream();
        OuputStream out = clientSock.getOutputStream();

        out.write("Hello from client..".getBytes());
        byte[] response = new byte[1024];
        in.read(response);
        System.out.prinln("Received from server.." + new String(response).trim());
        clientSock.close();
    }
}

```
