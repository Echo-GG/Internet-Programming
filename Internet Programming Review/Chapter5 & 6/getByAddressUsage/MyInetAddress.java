package getByAddressUsage;
import java.net.*;
public class MyInetAddress {
    public static void main(String[] args) throws Exception{
        byte[] ip = {(byte) 141, (byte)146, (byte)8, (byte)66};
        InetAddress address1 = InetAddress.getByAddress(ip);
        InetAddress address2 = InetAddress.getByAddress("Oracle 官方网站", ip);
        System.out.println(address1);
        System.out.println(address2);
    }
}
