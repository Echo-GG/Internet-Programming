# Socket Programming Thread Pool Aproach

```java
// More Efficient
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class ThreadPoolServer{
    private static final int THREAD_POOL_SIZE = 10;
    public static void main(String[] args) throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            Socket clientSocket = serverSocket.accept();
            executor.execute(new ClientHandler(clientSocket));
        }
    }
}

//the same (copied from Thread-per-Client Model)
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
