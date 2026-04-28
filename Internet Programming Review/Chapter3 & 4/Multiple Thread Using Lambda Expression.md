# Multiple Thread Using Lambda Expression

(Java 8+:)

## Alternative Version Using Lambda Expression (Java 8+)

```java
public class AnonymousThreadLambdaDemo{
    public static void main(String[] args){
        System.out.println("Main thread started. Creating 5 worker threads...");
        for(int i=1;i<=5;i++){
            new Thread(()->{
                System.out.println("Thread" + Thread.currentThread().getId() + "is running");
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    System.out.println("Thread interrupted");
                }
                System.out.println("Thread" + Thread.currentThread().getId() + "completed");
            }).start();
        }
        System.out.println("Main thread completed");
    }
}
```

### Key Features

1. Thread Scheduling
   1. The order of thread execution is not guaranteed
   2. Threads may complete in any order

2. Main Thread Behavior:
   1. The main thread may complete before worker threads finish
   2. To wait for all threads, you'd need to track them and use join()

3. Anonymous Thread Limitations:
   1. Can't directly access loop variable i (must be effectively final)
   2. Harder to manage individual threads compared to named instances

4. Lambda Syntax:

   () -> { ... } represents the run() method.

   No need to explicitly write new Runnable() or @Override public void run().
