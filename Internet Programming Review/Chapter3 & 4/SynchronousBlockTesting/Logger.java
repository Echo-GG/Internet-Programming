package SynchronousBlockTesting;
import java.util.Scanner;
class Logger {
    private static final Object lock = new Object();

    public static void log(String message, boolean useSync) {
        if (useSync) {
            synchronized (lock) {
                writeToLog(message);
            }
        } else {
            writeToLog(message);
        }
    }
    private static void writeToLog(String message){
        for(int i=0;i<10;i++){
            System.out.println(message + " - " + i);
            try {
                Thread.sleep(10); // Simulate some work
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

