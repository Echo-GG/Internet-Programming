package ZipAllFiles;
import java.io.*;
import java.util.concurrent.*;
public class GZipAllFiles {
    public final static int THREAD_COUNT = 4;
    public static void main(String[] args){
        ExecutorService pool= Executors.newFixedThreadPool(THREAD_COUNT);
        for(String filename: args){
            File f = new File(filename);
            if(f.exists()){
                if(f.isDirectory()){
                    File[] files = f.listFiles();
                    for(int i=0;i< files.length;i++){
                        if(!files[i].isDirectory()){ // don't recurse directories
                            Runnable task = new GZipRunnable(files[i]);
                            pool.submit(task);
                        }
                    }
                } else {
                    Runnable task = new GZipRunnable(f);
                    pool.submit(task);
                }
            }
        }
        pool.shutdown(); // 不会中止等待的工作，只是通知线程也没有新的工作线程任务需要增加到等待队列，池中所有任务完成即可关闭。
    }
}
