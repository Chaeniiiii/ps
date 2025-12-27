import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
       
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            map.put(skill.charAt(i),i);
        }
        
        int cnt = 0;
        for(String s : skill_trees){
            int idx = -1;
            cnt++;
            for(char c : s.toCharArray()){
                if(!map.containsKey(c)) continue;
                if(idx + 1 != map.get(c)){
                    cnt--;
                    break;
                }
                idx = map.get(c);
            }
        }
        
        return cnt;
        
    }
}