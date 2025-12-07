import java.util.*;

class Solution {
    public int solution(String name) {

        int n = name.length();
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            char c = name.charAt(i);
            cnt += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int mv = n - 1;
        for(int i = 0; i < n; i++){
            int nxt = i + 1;
            while(nxt < n && name.charAt(nxt) == 'A'){
                nxt++;
            }
            mv = Math.min(mv,Math.min(2*i + (n-nxt),  i + 2*(n-nxt)));
        }
        
        return cnt+mv;
        
    }
}
