import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int cnt = 0;
        
        for(String s : skill_trees){
            
            boolean check = false;
            int idx = 0;
            for(int i = 0; i<s.length(); i++){
                
                int now = s.charAt(i);
                
                if(skill.indexOf(now) == -1) continue;
                if(idx == skill.indexOf(now)) idx ++;
                else{
                    check = true;
                    break;    
                }
                
            }
            
            if(!check) cnt ++;
            
        }
        
        return cnt;
    }
}