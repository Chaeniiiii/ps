import java.util.*;

class Solution {
    
    private static long limit;
    private static int[] diffs, times;
    
    public int solution(int[] diffs, int[] times, long limit) {
    
        this.limit = limit;
        this.diffs = diffs;
        this.times = times;
        
        int lt = 1, rt = 100_000;
        
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            if(game(mid)){
                rt = mid - 1;
            }
            else{
                lt = mid + 1;
            }
            
        }   
        
        return lt;
        
    }
    
    private static boolean game(int level){
        
        long time = 0;
        
        for(int i = 0; i < diffs.length; i++){
            int dif = diffs[i];
            int nowT = times[i];
            if(dif <= level){;
                time += nowT;
            }
            else{
                long prevT = (i == 0 ? 0 : times[i-1]);
                int fault = dif - level;
                
                time += (nowT + prevT) * fault;
                time += nowT;
            }
        }
        
        return time <= limit ? true : false;
        
    }
    
}