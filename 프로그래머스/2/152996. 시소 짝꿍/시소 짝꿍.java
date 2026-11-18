import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        long cnt = 0;
        for(int w : weights){
            
            double a = w * 1.0;
            double b = (w * 2.0) / 3;
            double c = (w * 1.0) / 2;
            double d = (w * 3.0) / 4;
            
            if(map.getOrDefault(a,0) != 0) cnt += map.get(a);
            if(map.getOrDefault(b,0) != 0) cnt += map.get(b);
            if(map.getOrDefault(c,0) != 0) cnt += map.get(c);
            if(map.getOrDefault(d,0) != 0) cnt += map.get(d);
            
            map.put(a,map.getOrDefault(a,0)+1);
            
        }
        
        return cnt;
        
    }
}