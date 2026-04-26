# Streams

## InputStream, OutputStream, Reader, Writer are abstract classes.

## Subclasses can be classified by 2 different characteristics of sources / destinations:

1. For the Final Device (Data Sink Stream)

   purpose: serve as the source / destination of the stream (these streams 'really' write or read!)

2. For intermediate processing (processing stream)

   purpose: alters or manages information in the stream

   (these streams are 'luxury' additions, offering methods for convenience or more efficient stream-handling)

---

## 1. Data Sink Streams

### Data Sink Streams are streams that are directly connected to a data source or destination. such as a file, network connection, or memory.

### They are responsible for reading from or writing to the actual data source or sink.

## Data Sink Streams in Java:

1. FILE SINK STREAM

   (i). FileInputStream: Reads data from a file.
   
   (ii). FileOutputStream: Writes data to a file.

3. ByteArray Memory SINK Stream

   (i). ByteArrayInputStream: Reads data from a byte array in memory.
   
   (ii). ByteArrayOutputStream: Writes data to a byte array in memory.

4. Network SINK Stream

   (i). SocketInputStream: Reads data from a network socket.
   
   (ii). SocketOutputStream: Writes data to a network socket.

## These streams are low-level and deal directly with the raw data.

## 2. Processing Streams

### Processing Streams (also called Filter Streams) are streams that process or transform data as it is being read from or written to a Data Sink Stream.

### They are not directly connected to a data source or sink but instead wrap around another stream to provide additional functionality, such as buffering , filtering, or converting data.

## Processing Streams in Java:

1. Buffered Stream to Improve Performance:

   (i). BufferedInputStream: Adds buffering to an input stream , improving performance.
   
   (ii). BufferedOutputStream: Adds buffering to an output stream, improving performance.

3. Data Stream to Read and Write all Primitive DATA TYPES:

   (i). DataInputStream: Reads primitive data types (e.g. int, double )from an input stream.
   
   (ii). DataOutputStream: Writes objects to an output stream (used for serialization)

5. Object Stream to read and write OBJECT DATA TYPES:

   (i). ObjectInputStream: Reads objects from an input stream (used for deserialiazation).
   
   (ii). ObjectOutputStream: Writes objects to an output stream (used for serialization).

7. Reader / Writer Stream to read and write CHAR DATA TYPES:

   (i). InputStreamReader: Converts a byte stream to a character stream (used for reading text).
   
   (ii). OutputStreamWriter: Converts a character stream to a byte stream (used for writing text).

## These streams are high-level and deal with the data processing.
