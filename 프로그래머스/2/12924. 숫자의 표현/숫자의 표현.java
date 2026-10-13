import java.util.*;

class Solution {
    public int solution(int n) {
        
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0 && i % 2 == 1) result++;            
        }
        
        return result;
        
    }
}