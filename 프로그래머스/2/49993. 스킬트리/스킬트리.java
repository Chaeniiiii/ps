import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int cnt = skill_trees.length;
        Map<Character,Integer> map = init(skill);
        for(int i = 0; i < skill_trees.length; i++){
            String sk = skill_trees[i];
            int idx = 0;
            
            for(int j = 0; j < sk.length(); j++){
                char c = sk.charAt(j);
                if(map.containsKey(c)){
                    if(map.get(c) == idx) idx++;
                    else{
                        cnt--;
                        break;
                    }
                }
            }
        }
        
        return cnt;
        
    }
    
    private Map<Character,Integer> init(String skill){
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            map.put(skill.charAt(i),i);
        }
        
        return map;
        
    }
}