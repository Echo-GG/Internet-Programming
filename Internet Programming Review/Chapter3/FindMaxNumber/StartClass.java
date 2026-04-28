package FindMaxNumber;
// Result Collector Thread (Monitoring & Processing)
public class StartClass {
    public static void main(String[] args){
        int[] num = new int[1000];
        for(int i = 0; i < num.length; i++){
            num[i] = (int)(Math.random() * 1000);
        }
        for(int j=0;j< num.length;j++){
            System.out.print(num[j] + " ");
        }
        try{
            int maxNum = MultiThreadedMaxFinder.max(num);
            System.out.println("\nMax number is: " + maxNum);
        } catch(Exception ex){
            System.err.println(ex);
        }
    }
}
