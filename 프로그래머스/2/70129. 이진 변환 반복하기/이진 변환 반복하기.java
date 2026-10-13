import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] result = new int[2];
        while(!s.equals("1")){
            
            result[1] += s.length();
            s = s.replace("0","");
            
            int len = s.length();
            
            s = Integer.toBinaryString(len);
            
            result[0]++;
            result[1] -= len;
            
        }
        
        return result;
        
    }
    
}