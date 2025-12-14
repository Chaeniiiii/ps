import java.util.*;

class Solution {
    public String solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            
            int div = n % 3;
            n /= 3;
            
            if(div == 0){
                n--;
                div = 4;
            }
            
            sb.append(div);
                 
        }
        
        return sb.reverse().toString();
        
        
    }
}