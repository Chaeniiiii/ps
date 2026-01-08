import java.util.*;

class Solution {
    public int solution(int storey) {
        
        int cnt = 0;
        while(storey > 0){
            
            int div = storey % 10;
            int prev = (storey / 10) % 10;
            
            storey /= 10;
            
            if(div > 5){
                cnt += (10 - div);
                storey++;
            }
            else if(div < 5){
                cnt += div;
            }
            else{
                cnt+= div;
                if(prev >= 5) storey++;
            }
            
        }
        
        return cnt;
        
    }
}