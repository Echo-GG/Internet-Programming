# Asynchronous Computing Program Structure Design Model

> In multi-threaded programming, obtaining the results of asynchronous computing threads can be challenging. To address this issue, the Executor framework provides the Future interface, which allows for tracking the results of asynchronous computing. By using **Future**, a well-structured asynchronous computing program can be designed.

##  Based on Divide and Conquer Approach, The asynchronous computing threads can be divided into three categories based on their responsibilities:

1. **Initiating Thread (Control Thread)**: Responsible for decomposing and initiating asynchronous computing tasks, assigning tasks to worker threads, and obtaining a collection of Futures to track the results of asynchronous computing.

2. **Asynchronous Computing Work Thread**: Responsible for executing specific computing tasks.

3. **Asynchronous Calculation Result Collection Thread**: Obtains the Future collection from the initiating thread, monitors the status of Futures, and processes the results of asynchronous calculation based on the status.

## Implementation

```java
// (1). Control Thread (Task Decomposition, Task submit, Get Future)
import java.util.*;
import java.util.concurrent.*;

public class ControlThread{
    private final ExecutorService executor;
    private List<Future<Result>> futures = new ArrayList<>();

    public ControlThread(int threadPoolSize){
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    // Decompose main task and submit subtasks
    public void startProcessing(List<Task> subtasks){
        for(Task subtask:subtasks){
            Future<Result> future = executor.submit(new WorkerThread(subtask));
            futures.add(future);
        }
    }

    // Get Futures for monitoring
    public List<Future<Result>> getFutureCollection(){
        return Collections.unmodifiableList(futures);
    }

    public void shutdown(){
        executor.shutdown();
    }
}
```

```java
// (2). Worker Thread (Task Execution)
import java.util.concurrent.Callable;

public class WorkerThread implements Callable<Result>{
    private final Task task;

    public WorkerThread(Task task){
        this.task = task;
    }

    @Override
    public Result call() throws Exception{
        // Perform actual computation
        return task.execute();
    }
}
```

```java
// (3). Result Collector Thread (Monitoring & Processing)
import java.util.*;
import java.util.concurrent.*;

public class ResultCollectorThread implements Runnable{
    private final List<Future<Result>> futures;
    public ResultCollectorThread(List<Future<Result>> futures){
        this.futures = futures;
    }

    @Override
    public void run(){
        while(!allTasksCompleted()){
            try{
                processCompletedTasks();
                Thread.sleep(100); // Prevent busy waiting
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
        processRemainingTasks();
    }

    private boolean allTasksCompleted(){
        for(Future<Result>future: futures){
            if(!future.isDone())
                return false;
        }
        return true;
    }

    private void processCompletedTasks(){
        for(Future<Result> future: futures){
            if(future.isDone()){
                try{
                    Result result = future.get();
                    // Handle successful completion
                    System.out.println("Task completed: " + result);
                } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                } catch(ExecutionException e){
                    // Handle task failure
                    System.err.println("Task failed: " + e.getCause());
                }
            }
        }
    }

    private void processRemainingTasks(){
        // Process any remaining tasks after interruption
        processCompletedTasks();
    }
}

```

```java
public class Main{
    public static void main(String[] args){
        // 1. Prepare tasks
        List<Task> tasks = prepareTasks();

        // 2. Initialize control thread
        ControlThread controller = new ControlThread(4);

        // 3. Start processing
        controller.startProcessing(tasks);

        // 4. Start result collector
        new Thread(new ResultCollectorThread(controller.getFutureCollection())).start();

        // 5. Proper shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            collector.shutdown();
        }));
    }

    private static List<Task> prepareTasks(){
        // Return list of tasks to execute
        return Array.asList(
            new Task("Task1"),
            new Task("Task2"),
            new Task("Task3")
        );
    }
}
```

## Key Design Features

| Feature                 | Implementation                                              |
| ----------------------- | ----------------------------------------------------------- |
| Separation of Concerns  | Clear division between control, work, and collection        |
| Non-blocking Monitoring | Result collector checks status without blocking main thread |
| Error Handling          | Proper exception handling in result collector               |
| Resource Management     | ExecutorService lifecycle management                        |
| Thread Safety           | Unmodifiable future collection for safe sharing             |

## Performance Optimization Options

1. Callable Mechanism (Alternative to polling)

```java
future.thenAccept(result -> handleCompletion(result));
```

2. CompletionService (For result ordering):

```java
CompletionService<Result> cs = new ExecutorCompletionService<>(executor);
Future<Result> future = cs.submit(new WorkerThread(task));
Result result = cs.take().get(); // Gets results in completion order
```

3. Timeout Handling:

```java
try{
    Result result = future.get(1,TimeUnit.SECONDS);
} catch(TimeoutException e){
    future.cancel(true);
}
```

## Worker Thread (Task Execution)

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Asynchronous computing work thread
class ComputingTask implements Callable<Integer>{
    private int taskId;

    public ComputingTask(int taskId){
        this.taskId = taskId;
    }

    @Override
    public Integer Call(){
        // Simulate some computation
        System.out.println("Computing task" + taskId);
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return taskId * 10;
    }
}
```

## Result Collector Thread (Monitoring & Processing)

```java
// Asynchronous calculation result collection thread
class ResultCollector{
    public void collectResults(Future<Integer> future){
        try{
            int result = future.get();
            System.out.println("Result: " + result);
        } catch(InterruptedException | ExecutionException e){
            Thread.currentThread().interrupt();
        }
    }
}
```

## Control Thread (Task Decomposition,Task submit,Get Future)

```java
public class AsynchronousComputingExample{
    public static void main(String[] args){
        // Create an executor with a fixed thread pool size
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Initiating thread (control thread)
        for(int i=0;i<10;i++){
            ComputingTask task = new ComputingTask(i);
            Future<Integer> future = executor.submit(task);

            // Asynchronous calculation result collection thread
            ResultCollector collector = new ResultCollector();
            collector.collectResults(future);
        }

        // Shut down the executor
        executor.shutdown();
    }
}

```
