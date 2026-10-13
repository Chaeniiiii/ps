import java.util.*;

class Solution {
    public String solution(String s) {
        
        char[] str = s.toLowerCase().toCharArray();
        StringBuilder result = new StringBuilder();
        
        boolean flag = true;
        
        for(char c : str){
            result.append(flag ? Character.toUpperCase(c) : c);
            flag = (c == ' ' ? true : false);
        }    
        
        return result.toString();
        
    }
}