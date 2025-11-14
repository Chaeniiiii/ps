import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int lt = 0, rt = 0;
        int[] result = new int[2];
        
        int len = Integer.MAX_VALUE;
        int cnt = 0;
        
        while(rt < sequence.length){
            
            cnt+=sequence[rt];
            
            while(cnt > k){
                cnt-=sequence[lt++];
            }
            
            if(cnt == k){
                if(rt - lt < len){
                    len = rt - lt;
                    result[0] = lt;
                    result[1] = rt;
                }
            }
            
            rt++;
            
        }
        return result;
    }
}