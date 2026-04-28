package FindMaxNumber;
// Asynchronous Computing Worker Thread
import java.util.concurrent.Callable;
// Calculate Thread : Search for the maximum value in a given array of integers
class FindMaxTask implements Callable<Integer>{
    private int[] data;
    private int start;
    private int end;

    FindMaxTask(int[] data,int start,int end){
        this.data = data;
        this.start = start;
        this.end = end;
    }
    public Integer call(){
        int max = Integer.MIN_VALUE;
        for(int i = start; i < end; i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        return max;
    }
}
