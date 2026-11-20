import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        arr.sort((a,b) -> map.get(b) - map.get(a));
        
        int cnt = 0;
        for(int i = 0; i < arr.size(); i++){
            cnt += map.get(arr.get(i));
            if(cnt >= k) return i + 1;
        }
        
        return 0;
        
    }
}