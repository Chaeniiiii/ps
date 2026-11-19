import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) c = Character.toLowerCase(c);
            sb.append(c);
            
            if(c == ' ' || i == s.length() - 1){
                char nxtc = sb.charAt(0);
                if(Character.isAlphabetic(nxtc)) sb.setCharAt(0,Character.toUpperCase(nxtc));
                result.append(sb.toString());
                sb = new StringBuilder();
                continue;
            }
        }
        
        return result.toString();
        
    }
}