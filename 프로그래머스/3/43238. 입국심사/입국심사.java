import java.util.*;

class Solution {
    
    private static int[] times;
    private static final long MAX =  1_000_000_000;
    
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        this.times = times;
        
        long lt = 1, rt = MAX * MAX;
        long cnt =  rt;
        
        while(lt <= rt){
            
            long mid = (lt + rt)/2;
            
            if(check(mid) >= n){
                rt = mid - 1;
                cnt = Math.min(mid,cnt);
            }
            else{
                lt = mid + 1;
            }
            
        }
        
        return cnt;
        
    }
    
    private static long check(long num){
        
        long sum = 0;
        
        for(int t : times){
            sum += num / t;
        }
        
        return sum;
        
    }
}