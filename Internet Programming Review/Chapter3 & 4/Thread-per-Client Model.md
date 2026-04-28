# Thread-per-Client Model

```java
import java.net.*;
import java.io.*;
public class MultiThreadServer{
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            Socket clientSocket = serverSocket.accept();
            // Create a new thread for each client
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
}

class ClientHandler implements Runnable{
    private final Socket clientSocket;
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    public void run(){

        try(PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            String inputLine;
            while((inputLine = in.readLine())!=null){
                // Process client request
                out.println("Server: " + inputLine);
            }
        } catch(IOException e){
            System.out.pritnln("Exception in client handler");
        } finally{
            try{
                clientSocket.close();
            } catch(IOException e){
                // Handle close exception
            }
        }
    }
}

```
