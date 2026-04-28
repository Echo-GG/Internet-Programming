package getByAddressUsage;
import java.net.*;
public class GetByAddressWithHost {
    public static void main(String[] args) throws Exception{

        byte[] ipAddr = new byte[]{(byte)192, (byte)168, (byte)1, (byte)1};
        InetAddress inetAddress = InetAddress.getByAddress("myrouter.local", ipAddr);

        System.out.println("IP:" + inetAddress.getHostAddress()); // 192.168.1.1

        System.out.println("Hostname:" + inetAddress.getHostName()); // myrouter.local
    }
}
