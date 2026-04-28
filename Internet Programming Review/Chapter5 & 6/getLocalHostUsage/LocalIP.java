package getLocalHostUsage;
import java.net.InetAddress;
public class LocalIP {
    public static void main(String[] args)throws Exception{
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Local IP: " + localhost.getHostAddress());
        System.out.println("Local Hostname: " + localhost.getHostName());
    }
}
