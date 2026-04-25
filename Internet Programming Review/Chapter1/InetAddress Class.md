# InetAddress Class

1. Handle Internet addresses both as host names and as IP addresses.
2. Static Method getByName returns the IP address of a specified host name as an InetAddress object.
3. Methods for address/name conversion are as follow:

```java
public static InetAddress getByName(String host)throws UnknownHostException
public static InetAddress[] getAllByName(String host)throws UnknownHostException
public static InetAddress getLocalHost()throws UnknownHostException

public boolean isMulticastAddress()
public String getHostName()
public byte[] getAddress()
public String getHostAddress()
public int hashCode()
public boolean equals(Object obj)
public String toString()
```

e.g. Retrieving the current machine's address

```java
import java.net.*;
public class LocalIP{
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
        }catch(UnknownHostException e){
            System.out.println("Could not find local address!");
        }
    }
}
```
