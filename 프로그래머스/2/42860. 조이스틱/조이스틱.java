import java.util.*;

class Solution {
    public int solution(String name) {
        
        int n = name.length();
        int result = 0;
        for(char c : name.toCharArray()){
            result += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int mv = n - 1;
        for(int i = 0; i < n; i++){
            int nxt = i + 1;
            while(nxt < n && name.charAt(nxt) == 'A'){
                nxt++;
            }
            mv = Math.min(mv, Math.min(i*2 + n - nxt, 2*(n-nxt)+i));
        }
        
        return result + mv;
        
    }
}