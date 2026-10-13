import java.util.*;

class Solution {
    public String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String str : s.split(" ")){
            
            int num = Integer.parseInt(str);
            min = Math.min(num,min);
            max = Math.max(num,max);
            
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
        
    }
}