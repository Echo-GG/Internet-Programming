# Basic mode of socket connection in 4 steps

## 1. The server creates a ServerSocket object

```Java
try{
    ServerSocket waitSocketConnection = new ServerSocket(1880);
}catch(IOException e){}

// ServerSocket object is responsible for waiting for the client's request to arrive so as to establish a socket connection.

//ServerSocket obj_name = new ServerSocket(int port);
```

## 2. Server Accept Connection from Client

```Java
// When the server-side ServerSocket obj waitSocketConnection is established, the accept() method can be used to receive the client's socket connection request. The code is as follows:

Socket socketAtServer = waitSocketConnection.accept();

// The so-called "receiving" the client's socket request means that the accept() method will return a NEW Socket object (socketAtServer), which is called the server-side socket object.
```

## 3. The client creates a Socket object

```Java
// The client program can use the Socket class to create an object. The Socket constructor is: Socket(String host,int port)
Socket socketAtClient = new Socket(localhost,1880);
// Socket socketAtClient = new Socket();
// Constructors without parameters is also OK.

```

The object then calls:

```Java
public void connect(InetAddress endpoint)throws IOException
```

to request and establish a connection with the socket at the address specified by the parameter.

The client establishing a **Socket object**(socketAtClient) is to send a socket connection request to the server.

If there's a socket object on the corresponding port on the server that is using the accept() method to wait for client, then **the socket objects for both parties** (socketAtClient and socketAtServer) are born.

## 4. Stream Connection

**Once Socket objects** on the client and server are created, the input and output streams must be connected.

**The output stream** obtained by the server-side Socket object (socketAtServer) using the getOutputStream() method will point to **the input stream** obtained by the client-side Socket object (socketAtClient) using the getInputStream() method.

**The input stream** obtained by the server-side Socket object (socketAtServer) using the getInputStream() method will point to **the output stream** obtained by the client-side Socket object (socketAtClient) using the getOutputStream() method.

**Therefore, when the server writes information to the output stream , the client can read it through the corresponding input stream, and vice versa.**
