package getAllByNameUsage;
import java.net.InetAddress;
public class MultipleIPs {
    public static void main(String[] args) throws Exception{
        InetAddress[] addresses = InetAddress.getAllByName("google.com");
        for(InetAddress address: addresses){
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        }
    }
}
