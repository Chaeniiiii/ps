import java.util.*;

class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        long lt = 1, rt = limit;
        
        while(lt <= rt){
            
            long mid = (lt + rt) / 2;
            
            if(isCorrect(mid,diffs,times,limit)){
                rt = mid - 1;
            }
            else{
                lt = mid + 1;                
            }
            
        }
        
        return (int)lt;
        
    }
    
    private static boolean isCorrect(long level, int[] diffs, int[] times, long limit){
        
        long t = 0;
        int prevT = 0;
        
        for(int i = 0 ; i < diffs.length; i++){
            
            int df = diffs[i];
            if(df > level){
                t += ((times[i] + prevT) * (df - level) + times[i]);
            }
            else{
                t += times[i];
            }
            
            prevT = times[i];
            
        }
        
        if(t > limit) return false;
        return true;
        
    }
    
}