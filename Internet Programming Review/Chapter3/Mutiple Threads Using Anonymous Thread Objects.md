# Multiple Threads Using Anonymous Thread Objexts

## Java Class Demonstrating Multiple Threads Using Anonymous Thread Objects

```java
public class AnonymousThreadDemo{
    public static void main(String[] args){
        System.out.println("Main thread started. Creating 5 worker threads...");
        // Create and start 5 threads using a for loop
        for(int i=1;i<=5;i++){
            // Create anonymous Thread object
            new Thread(){
                @Override
                public void run(){
                    // Thread's task
                    System.out.println("Thread" + Thread.currentThread().getId() + "is running");
                    // Simulate some work
                    try{
                        Thread.sleep(1000); // sleep for a second
                    } catch(InterruptedException e){
                        System.out.println("Thread interrupted");
                    }

                    System.out.println("Thread" + Thread.currentThread.getId() + "completed");
                }
            }.start(); // Start the thread immediately
        }
        System.out.println("Main thread completed(but worker threads may still be running)");
    }
}
```

### Key Features

1. Anonymous Thread Creation:

2. Each thread is created anonymously inside the loop, The Thread class is extended and run() is overridden inline

3. Thread Identification: Uses Thread.currentThread().getId() to identify each thread Each thread gets a unique ID number

4. Simulated Work: Thread.sleep(1000) simulates 1 second of work

5. Includes basic exception handling

6. Output:Shows when each thread starts and completes, Main thread continues independently

7. Sample Output:

   Main thread started. Creating 5 worker threads...

   Main thread completed (but worker threads may still be running)

   Thread 14 is running

   Thread 15 is running

   Thread 16 is running

   Thread 17 is running

   Thread 18 is running

   Thread 14 completed

   Thread 15 completed

   Thread 16 completed

   Thread 17 completed

   Thread 18 completed
