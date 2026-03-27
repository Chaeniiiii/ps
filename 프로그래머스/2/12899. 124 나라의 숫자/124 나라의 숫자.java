import java.util.*;

class Solution {
    public String solution(int n) {
        
        int[] num = new int[]{4,1,2};
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            
            int d = n % 3;
            n /= 3;
            
            if(d == 0) n--;
            
            sb.append(num[d]);
            
        }
        
        return sb.reverse().toString();
        
    }
}