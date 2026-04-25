# Socket Communication Programming

## Server

```java
import java.io.*;
import java.net.*;
public class Server{
    public static void main(String[] args){
        ServerSocket server = null;
        Socket socketAtServer = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try{
            server = new ServerSocket(4333);
        }catch(IOException e){
            System.out.println("ERRO:"+e);
        }
        try{
            socketAtServer = server.accept();
            in = new DataInputStream(socketAtServer.getInputStream());
            out = new DataOutputStream(socketAtServer.getOutputStream());
            while(true){
                int m = 0;
                m = in.readInt();
                out.writeInt(m*2);
                System.out.println("Server received: "+m);
                Thread.sleep(500);
            }
        }catch(IOException e){
            System.out.println(""+e);
        }catch(InterruptedException e){
        }
    }
}

```

## Client

```java
import java.io.*;
import java.net.*;
public class Client{
    public static void main(String[] args){
        Socket socketAtClient;
        DataInputStream in = null;
        DataOutputStream out = null;
        try{
            socketAtClient = new Socket("localhost",4333);
            in = new DataInputStream(socketAtClient.getInputStream());
            out = new DataOutputStream(socketAtClient.getOutputStream());
            out.writeInt(1);
            while(true){
                int a2 = 0;
                m2 = in.readInt();
                out.writeInt(m2);
                System.out.println("Client received: "+ m2);
                Thread.sleep(500);
            }catch(IOException e){
                System.out.println("Unable to connect to the server");
            }catch(InterruptedException e){

            }
        }
    }
}

```
