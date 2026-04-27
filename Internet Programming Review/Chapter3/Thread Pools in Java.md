# Thread Pools in Java

1. A thread pool is a collection of pre-initialized worker threads that stand ready to execute tasks, providing a more efficient way to manage multiple threads in concurrent applications.

2. How Thread Pools Work
   1. Pool Creation: When you create a thread pool, it initializes a set of worker threads
   2. Task Submission: You submit tasks (as Runnable or Callable objects) to the pool
   3. Task Execution: The pool assigns tasks to available worker threads
   4. Thread Reuse: After completing a task, threads return to the pool for reuse

3. Key Components

   (i) Executor Framework Interfaces

   ```java

   Executor // Basic interface

   ExecutorService // Extended interface with lifecycle methods

   ScheduledExecutorService // For delayed or periodic execution
   ```

   (ii). Common Implementations

   ```java
       Executors.newFixedThreadPool(int n)     // Fixed number of threads

       Executors.newCachedThreadPool()         // Expands as needed

       Executors.newSingleThreadExecutor()     // Single worker thread

       Executors.newScheduledThreadPool(int n) // For scheduled tasks

       Executors.newWorkStealingPool()         // ForkJoinPool for parallel tasks
   ```

## Creating a ThreadPool - Four Step by Step Guide

A ThreadPool is a group of pre-initialized worker threads that efficiently execute multiple tasks concurrently. Instead of creating a new thread for every task, we reuse exsisting threads from the pool, improving performance and resource management.

### Step 1: Import Classes

Java provides the ExecutorService interface and Executors class to create thread pools.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
```

### Step 2: Create a ThreadPool Using Executors

Java offers different types of thread pools.

The most common are:

a). Fixed-Size ThreadPool : It has a fixed number of threads. If all threads are busy, new tasks wait in a queue.

```java
ExecutorService threadPool = Executors.newFixedThreadPool(4); // creates 4 threads
```

b). Cached ThreadPool : Creates new threads as needed. Reuses idle threads. Good for short-lived tasks.

```java
ExecutorService threadPool = Executors.newCachedThreadPool();
```

c). Single-Threaded Pool : Only one thread executes tasks sequentially.

```java
ExecutorService threadPool = Executors.newSingleThreadExecutor();
```

### Step 3: Submit Tasks to the ThreadPool

**Tasks can be submitted using ；**

**execute(Runnable task) → For tasks that don't return results.**

**submit(Callable task) → For tasks that return results (as a Future).**

### Example : Using execute()

```java
threadPool.execute(()->{
    System.out.println("Tasks running in: " + Thread.currentThread().getName());
});
```

### Example : Using submit()

```java
Future <String> futureResult = threadPool.submit(()->{
    return "Tasks completed!";
});
System.out.println(futureResult.get()); // Waits for result

```

### Step 4 : Shutdown the ThreadPool Properly

**shutdown() → Stops accepting new tasks but completes pending ones.**

**shutdownNow() → Attempts to stop all running tasks immediately.**

**awaitTermination() → Waits for tasks to finish (with timeout).**

```java
threadPool.shutdown() // Graceful shutdown

// Force shutdown if takes take too long
if(!threadPool.awaitTermination(60,TimeUnit.SECONDS)){
    threadPool.shutdownNow();
}

```

## Creating a Thread Pool - Example

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample{
    public static void main(String[] args){
        // Step 1 : Create a ThreadPool with 3 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // Step 2 : Submit tasks
        for(int i=1;i<=5;i++){
            int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Tasks" + taskId + "running in " + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000); //Simulate work
                } catch(InterruptedExecution e){
                    e.printStackTrace();
                }
            })
        }

        // Step 3 : Shutdown properly
        threadPool.shutdown();
        try{
            if(!threadPool.awaitTermination(5,TimeUnit.SECONDS)){
                threadPool.shutdownNow();
            }
        }
    }
}

```

**Output Example**

**Task 1 running in pool-1-thread-1**

**Task 2 running in pool-1-thread-2**

**Task 3 running in pool-1-thread-3**

**Task 4 running in pool-1-thread-1**

**Task 5 running in pool-1-thread-2**

## Key Takeaways

1. ✅ ThreadPool improves performance by reusing threads.

2. ✅ Use Executors.newFixedThreadPool(n) for controlled concurrency.

3. ✅ Submit tasks using execute() or submit().

4. ✅ Always shut down the pool **to avoid resource leaks**.
