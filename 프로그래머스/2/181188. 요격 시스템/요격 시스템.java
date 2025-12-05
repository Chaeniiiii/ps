import java.util.*;

class Solution {
    public int solution(int[][] targets) {
         
        Arrays.sort(targets,(a,b) -> a[1] - b[1]);
        
        int cnt = 0;
        int end = 0;
        for(int[] t : targets){
            
            if(t[0] >= end){
                end = t[1];
                cnt++;
            }
            
        }
        
        return cnt;
        
    }
}