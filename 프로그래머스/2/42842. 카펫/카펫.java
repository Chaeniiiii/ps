import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] result = new int[2];
        for(int h = 1; h <= Math.sqrt(yellow); h++){
            if(yellow % h != 0) continue;
            
            int w = yellow / h;
            int cnt = (w + 2) * 2 + h * 2;
            
            if(cnt == brown){
                result[0] = w + 2;
                result[1] = h + 2;
                break;
            }
        }
        
        return result;
        
    }
}