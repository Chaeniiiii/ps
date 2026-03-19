import java.util.*;

class Solution {
    
    private static int[] diffs;
    private static int[] times;
    private static long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
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
        
        long t = 0;
        
        for(int i = 0; i < diffs.length; i++){
            
            int diff = diffs[i];
            if(diff <= level){
                t += times[i];
            }
            else{
                int cnt = diff - level;
                long prev = i == 0 ? 0 : times[i-1];
                t += (times[i] + prev) * cnt;
                t += times[i];
            }
            
            if(t > limit) return false;
            
        }
        
        return true;
        
    }
    
}