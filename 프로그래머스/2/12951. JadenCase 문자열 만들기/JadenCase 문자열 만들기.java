import java.util.*;

class Solution {
    public String solution(String s) {
        
        s = s.toLowerCase();
        char[] str = s.toCharArray();

        int idx = 0;
        while(idx < s.length()){
            
            StringBuilder sb = new StringBuilder();
            int st = idx;
            
            while(idx < s.length() && str[idx++] != ' '){
                sb.append(str[idx-1]);
            }
            
            if(sb.length() == 0) continue;
            
            if(Character.isAlphabetic(sb.charAt(0))){
                str[st] = Character.toUpperCase(str[st]);
            }
            
        }
        
        StringBuilder result = new StringBuilder();
        for(char c : str){
            result.append(c);
        }
        
        return result.toString();
        
    }
}