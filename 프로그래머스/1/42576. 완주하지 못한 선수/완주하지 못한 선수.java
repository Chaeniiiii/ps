import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String,Integer> map = new HashMap<>();
        
        for(String name : completion){
            map.put(name,map.getOrDefault(name,0)+1);
        }
        
        for(String ptp : participant){
            if(!map.containsKey(ptp)) return ptp;
            
            if(map.get(ptp) == 1) map.remove(ptp);
            else map.put(ptp,map.get(ptp)-1);
            
        }
        
        return "";
        
    }
}