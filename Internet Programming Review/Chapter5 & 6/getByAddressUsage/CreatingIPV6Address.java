package getByAddressUsage;
import java.net.InetAddress;
public class CreatingIPV6Address {
    public static void main(String[] args) throws Exception{
        byte[] ipv6Addr = new byte[]{
                (byte)0x26, (byte)0x07, (byte)0xF8, (byte)0xB0,
                (byte)0x40, (byte)0x09, (byte)0x80, (byte)0xE0,
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
                (byte)0x00, (byte)0x00, (byte)0x20, (byte)0x0E
        };

        InetAddress address = InetAddress.getByAddress("ipv6.google.com",ipv6Addr);
        System.out.println("iPv6: " + address.getHostAddress()); // 2607:f8b0:4009:80e0::200e
        System.out.println("Hostname: " + address.getHostName()); // ipv6.google.com
    }
}
