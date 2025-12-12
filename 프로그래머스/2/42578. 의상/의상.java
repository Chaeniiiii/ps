import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String typ = clothes[i][1];
            map.put(typ,map.getOrDefault(typ,0)+1);
        }
        
        int size = map.keySet().size();
        
        if(size == 1){
            for(String key : map.keySet()){
                return map.get(key);
            }
        }
        
        int cnt = 1;
        for(String key : map.keySet()){
            
            cnt *= (map.get(key)+1);
            
        }
        
        return cnt - 1;
        
    }
}