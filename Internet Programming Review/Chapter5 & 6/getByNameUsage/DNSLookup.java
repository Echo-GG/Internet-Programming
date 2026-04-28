package getByNameUsage;
import java.net.InetAddress;
public class DNSLookup {
    public static void main(String[] args){
        if(args.length == 0){
            return ;
        }
        String host = args[0];
        try{
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println("IP Address: " + inetAddress.getHostAddress());
            System.out.println("Hostname: " + inetAddress.getHostName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
