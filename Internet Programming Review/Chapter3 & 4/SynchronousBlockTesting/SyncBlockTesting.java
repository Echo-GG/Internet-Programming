package SynchronousBlockTesting;

import java.util.Scanner;

public class SyncBlockTesting{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to use synchronization? (yes/no)");
        String input = scanner.nextLine();
        boolean useSync = input.equalsIgnoreCase("yes");

        System.out.println("Using" + (useSync ? " synchronization." : "); no synchronization."));
        for(int i=1;i<=5;i++){
            MyThread thread = new MyThread(i, useSync);
            thread.start();
        }
    }
}