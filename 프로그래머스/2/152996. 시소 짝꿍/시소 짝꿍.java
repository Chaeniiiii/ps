import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        Arrays.sort(weights);
        Map<Double,Integer> map = new HashMap<>();
        
        long result = 0;
        
        for(int weight : weights){
            
            double w = weight * 1.0;
            double a = (w * 2.0)/3.0;
            double b = w/2.0;
            double c = (w * 3.0)/4.0;
            
            if(map.containsKey(w)) result += map.get(w);
            if(map.containsKey(a)) result += map.get(a);
            if(map.containsKey(b)) result += map.get(b);
            if(map.containsKey(c)) result += map.get(c);
            
            map.put(w, map.getOrDefault(w,0)+1);
            
        }
        
        return result;
        
    }
}