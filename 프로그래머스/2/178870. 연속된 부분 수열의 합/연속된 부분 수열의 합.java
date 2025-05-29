import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int len = Integer.MAX_VALUE;
        int lt = 0, rt = 0;
        
        int[] result = new int[2];
        
        int sum = 0;
        while(lt <= rt){
            
            if(rt >= sequence.length) break;
            
            sum+=sequence[rt];
            
            while(sum >= k){
                
                if(sum == k && (rt - lt) <len){
                    result[0] = lt;
                    result[1] = rt;
                    len = rt - lt;
                }
                
                sum-=sequence[lt];
                lt ++;
                
            }
            
            rt++;
            
        }
        
        return result;
        
    }
}