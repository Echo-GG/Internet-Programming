package SynchronousBlockTesting;
import java.util.Scanner;
public class MyThread extends Thread{
    private int threadNumber;
    private boolean useSync;
    public MyThread(int threadNumber, boolean useSync){
        this.threadNumber = threadNumber;
        this.useSync = useSync;
    }
    @Override
    public void run() {
        Logger.log("Message from Thread " + threadNumber, useSync);
    }
}
