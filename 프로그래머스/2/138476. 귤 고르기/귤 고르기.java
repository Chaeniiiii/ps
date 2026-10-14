import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            int n = tangerine[i];
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        arr.sort((a,b) -> map.get(b) - map.get(a));
        
        int cnt = 0;
        int idx = 0;
        while(idx < arr.size() && cnt < k){
            cnt += map.get(arr.get(idx++));
        }
        
        return idx;
        
    }
}