import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int len = sequence.length;
        
        long [] a = new long [len];
        long [] b = new long [len];
        
        int [] purse = new int[len];
        Arrays.fill(purse,1);
        
        for(int i = 0; i<len; i+=2) purse[i]*=-1;
            
        for(int i = 0; i<len; i++){
            a[i] = sequence[i] * purse[i];
            b[i] = sequence[i] * purse[i]*-1;
        }
        
        long result = 0;
        result = Math.max(calc(a,len),Math.max(calc(b,len),result));
        
        return result;
        
    }
    
    private static long calc(long [] sqn, int len){
        
        long cnt = sqn[0];
        for(int i = 1; i<len; i ++){
            sqn[i] = Math.max(sqn[i],sqn[i-1]+sqn[i]);
            cnt = Math.max(sqn[i],cnt);
        }
        
        return cnt;
        
    }
    
}