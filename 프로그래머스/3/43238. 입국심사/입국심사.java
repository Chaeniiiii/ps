import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        long lt = 0, rt = times[times.length - 1] * (long)n;
        long result = 0;
        
        while(lt <= rt){
            
            long mid = (lt + rt) / 2;
            if(test(mid,n,times)){
                rt = mid - 1;
                result = mid;
            }
            else{
                lt = mid + 1;
            }
            
        }
        
        return result;
        
    }
    
    private boolean test(long time,int n, int[] times){
        
        long cnt = 0;
        for(int i = 0; i < times.length; i++){
            cnt += time / times[i];
        }
        
        return cnt >= n ? true : false;
        
    }
    
}