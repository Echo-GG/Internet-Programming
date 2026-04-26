# Object Stream

## In Java, you can use Object Streams (ObjectOutputStream and ObjectInputStream) to serialize and deserialize objects.

## Serialization is the process of converting an object into a byte stream, and deserialization is the process of converting the byte stream back into an object.

---

## ObjectInputStream and ObjectOutputStream

### The objects created by the ObjectInputStream class are called object input streams

### The objects created by the ObjectOutputStream class are called object output streams

### The object output stream uses the writeObject(Object obj) method to write an object obj to the output stream.

### Object input stream uses readObject() to read an object from the source into the program.

### If a class implements the Serializable interface, then the object created by this class is a serializable object .

### When a serialized object is written to an object output stream, the JVM automatically writes the object to the destination in a certain format.

---

1. **Serializable** refers to the ability of an object to be converted into a byte stream, which can then be saved to a file, sent over a network, or stored in a database. To make a class serializable in Java, it must implement the java.io.Serializable interface. This process is known as serialization.

2. The reverse process, where a byte stream is converted back into an object, is called **deserialization**.

3. **Serialization Process**: The ObjectOutputStream class is used to serialize an object. The writeObject() method writes the object to an output stream.

4. **Deserialization Process**: The ObjectInputStream class is used to deserialize an object. The readObject() method reads the object from an input stream.

```java
import java.io.Serializable;
public class MyClass implements Serializable {
    // Class fields and methods
    }
```

5. When to Use Object Streams:

   a) Use object streams when you need to save and restore the state of objects (e.g., in file-based storage or network communication).

   b)Avoid using object streams for simple data types or when human-readable file formats (e.g., JSON, XML) are preferred.

## Examples using Object Stream

### Example 1

```java
import java.io.Serializable;
// Goods class implementing Serializable
public class Goods implements Serializable{
    private String name;
    private double price;

    // Constructor
    public Goods(String name,double price){
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    // Override toString() for better representation
    @Override
    public String toString(){
        return "Goods{name = " + name + ",price = " + price +"}";
    }
}
```

```java
import java.io.*;
public class ObjectStreamExample{
    public static void main(String[] args){
        // File to store the serialized object
        String filePath = "goods.ser";

        // Create a Goods object
        Goods TV1 = new Goods("HaierTV",3468);

        // Serialize the object
        try(FileOutputStream fos = new FileoutputStream(filePath); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            // Write the object to the file
            oos.writeObject(TV1);
            System.out.println("Object serialized and save to" + filePath);
        } catch (IOException e){
            e.printStackTrace();
        }
        // Deserialize the object
        try(FileInputStream fis = new FileInputStream(filePath); ObjectInputStream ois = new ObjectInputStream(fis)){
            // Read the object from the file
            Goods deserializedTV1 = (Good) ois.readObject();
            System.out.println("Object deserialized:" + deserializedTV1);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        // Object serialized and saved to goods.ser
        // Object deserialized: Goods{name='HaierTV', price=3468.0}

    }
}
```

### Example 2

```java
import java.io.*;
class MyClass implements Serializable{
    private static final long seriaVersionUID = 1L;
    private String name;
    private transient int age; // This field will not be serialized

    public MyClass(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "MyClass(name = " + name + ",age = " + age + "}";
    }
}
```

```java
public class SerializationExample{
    public static void main(String[] args){
        // Serialization
        try(ObjectOutputStream  oos = new ObjectOutputStream(new FileOuputStream("myclass.ser"))){
            MyClass obj = new MyClass("John",30);
            oos.writeObject(obj);
            System.out.println("Object serialized:" + obj);
        }catch(IOException e){
            e.printStackTrace();
        }

        // Deserialization
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myclass.ser"))){
            MyClass obj = (MyClass) ois.readObject();
            System.out.println("Object deserialized:" + obj);
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

//OUTPUT:

// Object serialized: MyClass{name='John', age=30}

// Object deserialized: MyClass{name='John', age=0}
// age is 0 because it was transient

```

## When to Use Serialization

1. Saving object state to a file or database.

2. Sending objects over a network (e.g., in distributed systems).

3. Caching objects in memory.

## Limitations

1. Serialization can be slow and resource-intensive.

2. It may introduce security risks if not handled properly (e.g., deserialization of untrusted data can lead to vulnerabilities).

3. Changes to the class structure (e.g., adding/removing fields) can break compatibility.

4. By understanding serialization, you can effectively persist and transfer object data in Java applications.
