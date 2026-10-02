import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String[] c = clothes[i];
            map.put(c[1],map.getOrDefault(c[1],0)+1);
        }
        
        int cnt = 1;
        for(String key : map.keySet()){
            map.put(key,map.get(key) + 1);
            cnt *= map.get(key);
        }
        
        return cnt - 1;
        
    }
}