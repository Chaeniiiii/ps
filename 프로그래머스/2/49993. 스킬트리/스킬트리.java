import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int cnt = 0;
        
        for(String st : skill_trees){
            
            int now = 0;
            boolean check = true;
            
            for(int i = 0; i < st.length(); i++){

                char c = st.charAt(i);
                int tg = skill.indexOf(c);
                
                if(tg == -1) continue;
                
                if((now == 0 && tg > 0) || now != tg){
                    check = false;
                    break;
                }
                
                now = tg+1;
                
            }
            
            if(check){
                cnt++;
            }
            
        }
        
        return cnt;

    }
        
}