# The Life Cycle of a Java Thread

## New --> (Runnable --> blocked/waiting) \* --> Runnable --> dead(terminated)

```java
sleep (long ms[,int ns]);
// sleep (ms + ns × 10^-3) milliseconds and then continue
```

```java
// [IO] blocked by synchronized method/block
synchronized (obj) {
    //...
    } // synchronized statement

synchronized m(//...
){
    //...
} // synchronized method

//return to runnable by obj.notify() or obj.notifyAll()

```

```java
join(long ms[,int ns]);
// Waits at most ms milliseconds plus ns nanoseconds for this thread to die.
```
