# ServerSocket Class

## 1. Constructors

```Java
//1. Binds to specified port with default backlog (50)
ServerSocket(int port)throws IOException

//2. Binds to specified port with custom backlog
ServerSocket(int port,int backlog)throws IOException

//3. Binds to specified port, backlog, and local IP address
ServerSocket(int port,int backlog,InetAddress bindAddr)throws IOException

//4. Creates unbound server socket
ServerSocket()throws IOException
```

## 2. Core Methods

### i. Binding & Connection Methods

```Java
void bind(SocketAddress endpoint) // Binds socket to specific address/port
void bind(SocketAddress endpoint,int backlog) // Binds with custom backlog
// backlog is the maximum size of the queue of connection requests
Socket accept() // BLOKING - Waits for client connection
void close() // Closes server socket, releases port
boolean isClosed() // Checks if socket is closed
boolean isBound() // Checks if socket is bound
```

### ii. Information Methods

```Java
// Get local port server is listening on
int getLocalPort()

// Get local socket address
SocketAddress getLocalSocketAddress()

// Get InetAddress of local server
InetAddress getInetAddress()
```
