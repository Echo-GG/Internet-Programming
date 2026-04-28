# Commonly Used Methods

|     | Return Type          | Method                                | Description                                                                                                                      |
| --- | -------------------- | ------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| 1   | static InetAddress   | getByName(String host)                | Returns InetAddress for a host (IP or domain)                                                                                    |
| 2   | static InetAddress[] | getAllByName(String host)             | Returns all IPs for a host (if multiple exist)                                                                                   |
| 3   | static InetAddress   | getLocalHost()                        | Returns the local machine's IP.                                                                                                  |
| 4   | String               | getHostName()                         | Returns the hostname (performs reverse DNS if needed)                                                                            |
| 5   | String               | getHostAddress()                      | Returns the IP as a string (e.g. "192.168.1.1").                                                                                 |
| 6   | boolean              | isReachable(int timeout)              | Checks if the host is reachable (ICMP ping)                                                                                      |
| 7   | byte[]               | getAddress()                          | Returns the raw IP address of this InetAddress object.                                                                           |
| 8   | static InetAddress[] | getByteAddress(byte[] addr)           | Returns an InetAddress object given the raw IP address                                                                           |
| 9   | static InetAddress[] | getByAddress(String host,byte[] addr) | Create an InetAddress based on the provided host name and IPaddress. No name service is checked for the validity of the address. |
