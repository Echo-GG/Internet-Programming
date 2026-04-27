# Constructors and Methods

```java
// The java.lang.Thread constructors
// Public Constructors

// Thread([ThreadGroup group,][Runnable target,][String name]);
// Instances:

Thread();
Thread(Runnable target);
Thread(Runnable target,String name);
Thread(String name);
Thread(ThreadGroup group,Runnable target);
Thread(ThreadGroup group,Runnable target,String name);
Thread(ThreadGroup group,String name);
// name is a string used to identify the thread instance
// group is the thread group to which this thread belongs
```

```java
// Some thread property access methods

int getID()
// every thread has a unique ID,since jdk1.5

String getName();
void setName(String name);
// get/set the name of the thread

ThreadGroup getThreadGroup();
int getPriority();
void setPriority(int pri);
// thread has priority in [0,31]

Thread.State getState();
// return current state of this thread

boolean isAlive();
// Tests if this thread has been started and has not yet died.

boolean isDaemon();
// Tests if this thread is a daemon thread.

boolean isInterrupted();
// Tests whether this thread has been interrupted.

```

```java
// State methods for current thread accesses

static Thread currentThread();
// Returns a reference to the currently executing thread object.

static boolean holdsLock(Object obj);
// Returns true if and only if the current thread holds the monitor lock on the specified object.

static boolean interrupted();
// Tests whether the current thread has been interrupted.

static void sleep([long millis[,int nanos]]);
// Causes the currently executing thread to sleep (cease execution) for the specified time.

static void yield()
// Causes the currently executing thread object to temporarily pause and allow other threads to execute.

```

## Example

```java
public class SimpleThread extends Thread{
    public SimpleThread(String str){
        super(str);
    }

    // The constructors takes a String parameter (str) and passes it to the parent Thread class constructor. This sets the thread's name, which can be retrieved later with getName();

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i+""+getName());
            try{
                // at this point, current thread is 'this'.
                Thread.sleep((long)(Math.random()*1000));
            } catch(InterruptedException e){

            }
        }
        System.out.println("DONE! "+getName());
    }

}

```

```java
// main program
public class TwoThreadsTest{
    public static void main(String[] args){
        new SimpleThread("Thread1").start();
        new SimpleThread("Thread2").start();
    }
}

```
