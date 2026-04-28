package CreateInetAddressObject;
import java.net.*;

public class OReillyByName {
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println(address);
        } catch(UnknownHostException ex){
            System.out.println("Could not find www.oreilly.com");
        }
    }
}
