import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        
        int[] result = new int[2];
        while(!s.equals("1")){
            
            String num = s.replace("0","");
            int len = num.length();
            
            result[1] += (s.length() - len);
            result[0] ++;
            s = Integer.toString(len,2);
                    
        }
        
        return result;
        
    }
    
}