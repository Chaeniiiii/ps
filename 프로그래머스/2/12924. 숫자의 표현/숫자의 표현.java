import java.util.*;

class Solution {
    public int solution(int n) {
        
        int result = 0;
        int lt = 1, sum = 0;
        
        for(int rt = 1; rt <= n; rt++){
            sum += rt;
            
            while(sum > n){
                sum -= lt++;
            }
            
            if(sum == n) result++;
            
        }
        
        return result;
        
    }
}