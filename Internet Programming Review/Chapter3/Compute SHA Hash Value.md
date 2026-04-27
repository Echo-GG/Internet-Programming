# Compute SHA Hash Value

e.g. SHA-256 for single file

```java
import java.io.*;
import java.security.*;
public class DigestExample{
    public static void main(String[] args)throws Exception{
        // 1. Choose a digest algorithm (e.g.SHA-256 in this case)
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try(InputStream is = new FileInputStream("example.txt"); DigestInputStream dis = new DigestInputStream(is,md)){
            // 2. Read through the stream - digest is updated automatically
            // Just reading - digest is updated in background
            while(dis.read()!=-1){

            }
            // 3. Get the digest value
            byte[] digest = md.digest();
            // 4. Convert to hexadecimal representation
            StringBuilder hexString = new StringBuilder();
             for(byte b:digest){
                hexString.append(String.format("%02x",b));
            }
            System.out.println("SHA-256 Digest" + hexString.toString());

        }
    }
}

```

## 1. Important Methods

```java
DigestInputStream(InputStream stream, MessageDigest digest)
// Constructor that wraps an existing input stream

MessageDigest getMessageDigest()
// Returns the associated message digest object

void setMessageDigest(MessageDigest digest)
// Associates a different digest with the stream

void on(boolean on)
// Turns digest functionality on/off (default is on)

```

## 2. Performance Consideration

1. Adds minimal overhead to stream processing

2. Digest is computed incrementally as data is read

3. More efficient than reading the stream first and then computing digest separately

4. Security Algorithms Available that you can use with DigestInputStream:

   (i). MD5 (not recommended for security purposes)

   (ii). SHA-1 (being phased out)

   (iii). SHA-256 (recommended)

   (iv). SHA-384

   (v). SHA-512

**You'd specify these algorithms when creating the MessageDigest instance (e.g., MessageDigest.getInstance("SHA-256")).**

## Compute SHA hash value (like SHA-256) for multiple files without using threads

```java
import java.io.*;
import java.security.*;
public class FileHashCalculator{
    public static void main(String[] args){
        String[] files = {"file1.txt","file2.txt","file3.txt"};
        String algorithm = "SHA-256"; // Choose SHA-1,SHA-384,etc.
        for(String file:files){
            try{
                byte[] fileHash = calculateSHA(new File(file),algorithm);
                System.out.println(file + ":" + bytesToHex(fileHash));
            } catch(Exception e){
                System.err.println("Error processing" + file +":" + e.getMessage());
            }
        }
    }

    // Compute SHA hash of a file
    private static byte[] calculateSHA(File file,String algorithm) throws IOException,NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        try(InputStream is = new FileInputStream(file); DigestInputStream dis = new DigestInputStream(is,digest)){
            while(dis.read()!=-1){
                // Return entire file to update digest
            }
            return digest.digest();
        }
        return digest.digest();
    }

    // Coverts byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes){
        StringBuilder hexString = new StringBuilder();
        for(byte b: bytes){
            hexString.append(String.format("%02",b));
        }
        return hexString.toString();
    }

}

```

## Compute SHA hash value (like SHA-256) for multiple files using threads

```java
import java.io.*;
import java.security.*;
public class MultithreadedFileHashCalculator{
    public static void main(String[] args){
        String[] files = {"file1.txt","file2.txt","file3.txt"};
        for(String file:files){
            new Thread(() -> {
                try{
                    String hash = calculateFileHash(file,"SHA-256");
                    System.out.println(file + ": " + hash);
                } catch (Exception e){
                    System.err.println("Error in " + file + ": " + e.getMessage());
                }
            }).start();
        }
    }

    private static String calculateFileHash(String filename,String algorithm) throws IOException , NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        try(InputStream is = new BufferedInputStream(new FileInputStream(filename)); DigestInputStream dis = new DigestInputStream(is,digest)){
            while(dis.read()!=-1); // Auto-updates digest during read
            return bytesToHex(digest.digest());
        }
    }

    private static String bytesToHex(byte[] bytes){
        StringBuilder hex = new StringBuilder();
        for(byte b: bytes){
            hex.append(String.format("%02x",b));
        }
        return hex.toString();
    }
}

```
