# How to Define and Launch a Thread

## Define a Thread

Each Java Run time thread is encapsulated in a java.lang.Thread instance.

There are 2 ways to define a thread:

1. Subclass the Thread class

2. Override the default Thread method **run()**

( which is **the entry point of the thread**, like the main(String[]) method in a java program. )

### Example

```java
public class Print2Console extends Thread{
    public void run(){
        // run() is to a thread what main() is to a java program
        for(int b = -128;b < 128;b++){
            out.println(b);
            // additional methods, fields ...
        }
    }
}
```

### Implement the Runnable interface if you need a parent class:

```java
// by extending JTextArea we can reuse all existing code of JTextArea
public class Print2GUI extend JTextArea implement Runnable{
    public void run(){
        for(int b = -128;b < 128;b++){
            append(Integer.toString(b) + "\n");
        }
    }
}
```

## Launch a Thread

1. Create an instance of Thread (or a subclass of Thread)

```java
Thread thread1 = new Print2Console();
Thread thread2 = new Thread(new Print2GUI);
```

2. Call its start() method, thread.start();
   > Note: note call run() !!

```java
Print2Console t1 = new Print2Console(); // t1 is a thread instance !
t1.start(); // This will start a new thread, which begins its execution by calling t1.run()
// ...
// Parent thread continue immediately here without waiting for the child thread to complete its execution.
t1.run();
Print2GUI jtext = new Print2GUI();
Thread t2 = new Thread(jtext);
t2.start();
// ...

```
