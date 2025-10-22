import java.util.*;

class Solution {
    public int solution(String s) {
        
        int result = s.length(); 

        for (int cut = 1; cut <= s.length() / 2; cut++) {
            
            StringBuilder sb = new StringBuilder();
            
            String prev = s.substring(0, cut);
            int cnt = 1;

            for (int i = cut; i < s.length(); i += cut) {
                
                int end = Math.min(i + cut, s.length());
                String cur = s.substring(i, end);

                if (cur.equals(prev)) cnt++;
                else {
                    if (cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = cur;
                    cnt = 1;
                    
                }
            }

            if (cnt > 1) sb.append(cnt);
            sb.append(prev);

            result = Math.min(result, sb.length());
            
        }

        return result;
    }
}
