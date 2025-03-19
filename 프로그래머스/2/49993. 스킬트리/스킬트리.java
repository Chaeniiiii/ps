import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        boolean [] chr = new boolean[26];
        for(char c : skill.toCharArray()) chr[(int)(c-'A')] = true;
        
        int cnt = 0;
        for(String s : skill_trees){
            
            Deque<Character> deque = new ArrayDeque<>();
            for(char c : s.toCharArray()) deque.add(c);
            
            int idx = 0;
            boolean check = false;
            while(!deque.isEmpty()){
                
                if(idx == skill.length()) break;
                
                char now = deque.poll();
                
                if(now != skill.charAt(idx) && chr[(int)(now-'A')]){
                    check = true;
                    break;
                }
                
                if(now == skill.charAt(idx)) idx ++;
                
            }
            
            if(!check) cnt++;
            
        }
        
        return cnt;
        
    }
}