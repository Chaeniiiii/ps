import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(String s) {
        
        int[] result = new int[2];
        while(!s.equals("1")){
            
            int cnt = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') cnt++;
            }
            
            result[1] += cnt;
            s = s.replace("0","");
            
            BigInteger num = new BigInteger(String.valueOf(s.length()));
            s = num.toString(2);
            result[0]++;
        }
        
        return result;
        
    }
    
}