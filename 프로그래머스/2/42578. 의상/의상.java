import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {

        Map<String,Integer>map = new HashMap<>();
        for(String [] str : clothes) map.put(str[1],map.getOrDefault(str[1],0)+1);
    
        int cnt = 1;        
        for(String key : map.keySet()){
            cnt *= map.get(key)+1;
            
        }
        
        return cnt-1;
        
        
    }
    
}