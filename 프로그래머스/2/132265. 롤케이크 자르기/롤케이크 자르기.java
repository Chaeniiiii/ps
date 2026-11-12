import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < topping.length; i++){
            int tp = topping[i];
            map.put(tp,map.getOrDefault(tp,0)+1);
        }
        
        Set<Integer> set = new HashSet<>();
        int a = map.keySet().size();
        int cnt = 0;
        
        for(int i = 0; i < topping.length; i++){
            int tp = topping[i];
            set.add(tp);
            
            map.put(tp,map.get(tp) - 1);
            if(map.get(tp) == 0) a--;
            
            if(a == set.size()) cnt++;
        }
        
        return cnt;
        
    }
}