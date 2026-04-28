package getByAddressUsage;
import java.net.InetAddress;
public class GetByAddressExample {
    public static void main(String[] args) throws Exception{
        byte[] ipAddr = new byte[]{(byte)142, (byte)250, (byte)190, (byte)46};
        // Google's IP
        InetAddress address = InetAddress.getByAddress(ipAddr);

        System.out.println("IP:" + address.getHostAddress()); // 142.250.190.46

        System.out.println("Hostname: " + address.getHostName()); // ord37s33-in-f14.1e100.net
        // May return IP if no reverse DNS
    }
}
