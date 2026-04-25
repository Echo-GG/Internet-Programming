# UDPServer

```java
// Server receive message and converts it to UPPERCASE
import java.io.*;
import java.net.*;
class UDPServer{
    public static void main(String[] args)throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9876);
        // variable to hold data to be received and sent
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            // create Datagram packet receive data
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            serverSocket.receive(receivePacket);
            // extract data from datagram packet
            String sentence = new String(receivePacket.getData());
            // extract IP address from datagram packet
            InetAddress IPAddress = receivePacket.getAddress();
            // extract Port address from datagram packet
            int port = receivePacket.getPort();

            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            // create Datagram packet to send data
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
            // Send Datagram packet
            serverSocket.send(sendPacket);
        }
    }
}
```
