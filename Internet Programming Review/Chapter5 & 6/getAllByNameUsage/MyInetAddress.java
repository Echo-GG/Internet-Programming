package getAllByNameUsage;
import java.net.*;
public class MyInetAddress {
    public static void main(String[] args) throws Exception{
        if(args.length == 0){
            return ;
        }
        String host = args[0];
        InetAddress[] addresses = InetAddress.getAllByName(host);
        for(InetAddress address: addresses){
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        }
    }
}
