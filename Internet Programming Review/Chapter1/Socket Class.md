# Socket Class

## 1. Constructors

```Java
// 1.Create and connect immediately
Socket(String host,int port)throws UnknownHostException,IOException
Socket(InetAddress address,int port)throws IOException

//2.Connect with local address binding
Socket(String host,int port,InetAddress localAddr,int localPort)throws IOException
Socket(InetAddress address,int port,InetAddress localAddr,int localPort)throws IOException

//3.Create unconnected socket (for later connection)
Socket()throws IOException

//4.Create with proxy
Socket(Proxy proxy)throws IOException

```

## 2. Core Methods

### i) Connection Status Method

```Java
// Connection state
void connect(SocketAddress endpoint)throws IOException
void connect(SocketAddress endpoint,int timeout)throws IOException

boolean isConnected() // Returns true if connect() was called
boolean isClosed() // Returns true if socket was closed
boolean isBound() // Returns true if socket is bound to local address
boolean isInputShutdown() //Returns true if input half-closed
boolean isOutputShutdown() // Returns true if output half-closed
```

### ii) I/O Stream Methods

```Java
// Get input stream for receiving data
InputStream getInputStream()throws IOException
// Get output stream for sending data
OutputStream getOutputStream()throws IOException
```

### iii) Address Information methods

```Java
InetAddress getInetAddress() // Remote IP address
int getPort() // Remote port
SocketAddress getRemoteSocketAddress() // Remote address + port

// Local endpoint (client) info
InetAddress getLocalAddress() // Local IP address
int getLocalPort() // Local port
SocketAddress getLocalSocketAddress() // Local address + port
```
