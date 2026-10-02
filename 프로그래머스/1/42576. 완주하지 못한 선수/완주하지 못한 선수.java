import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String,Integer> map = new HashMap<>();
        for(String pt : participant){
            map.put(pt,map.getOrDefault(pt,0)+1);
        }
        
        for(String cp : completion){
            if(map.get(cp) == 1) map.remove(cp);
            else map.put(cp,map.get(cp) - 1);
        }
        
        String result = "";
        for(String notC : map.keySet()) result = notC;
        
        return result;
        
    }
}