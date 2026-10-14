import java.util.*;

class Solution {
    
    private Map<String,Integer> origin;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        origin = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            origin.put(want[i],number[i]);
        }
        
        int max = 10;
        int lt = 0, rt = lt + max;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = lt; i < rt; i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);    
        }
        
        int cnt = 0;
        while(rt < discount.length){
            
            if(isPossible(map)) cnt++;
            
            String name = discount[lt];
            if(map.get(name) == 1) map.remove(name);
            else map.put(name,map.get(name) - 1);

            lt++;
            map.put(discount[rt],map.getOrDefault(discount[rt],0)+1);
            rt++;
            
        }

        if(isPossible(map)) cnt++;
        return cnt;
        
    }
    
    private boolean isPossible(Map<String,Integer> map){
     
        if(map.keySet().size() != origin.keySet().size()) return false;
        for(String key : map.keySet()){
            if(map.get(key) != origin.get(key)) return false;
        }
        
        return true;
        
    }
}