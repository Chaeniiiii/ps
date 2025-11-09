import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long lt = 1;
        long rt = (long)(10e5*2*10e9*2);
        long result = 0;
        
        while(lt <= rt){
            
            long mid = (lt + rt) / 2;
            
            int gold = 0 , siver = 0, sum = 0;
            for(int i = 0; i < g.length; i++){
                long cnt = mid / (t[i]*2);
                if(mid % (t[i]*2) >= t[i]) cnt++;
                
                gold += Math.min(g[i],w[i]*cnt);
                siver += Math.min(s[i],w[i]*cnt);
                sum += Math.min(g[i]+s[i],w[i]*cnt);
            }
            
            if(gold >= a && siver >= b && sum >= a+b){
                result = mid;
                rt = mid-1;
            }
            else{
                lt = mid+1;
            }
        }
        
        return result;
        
    }
}