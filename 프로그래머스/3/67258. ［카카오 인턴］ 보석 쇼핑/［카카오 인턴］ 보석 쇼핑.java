import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> gemSet = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for(String gem : gems) gemSet.add(gem);
        
        int gemSize = gemSet.size();
        int left = 0, right = 0, len = Integer.MAX_VALUE;
        int [] result = new int[2];
        
        while(left <= right){
            
            if(right >= gems.length) break;
            map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            
            while(map.size() == gemSize){
                
                if(left > right) break;
                if(right - left < len){
                    len = right - left;
                    result[0] = left+1;
                    result[1] = right+1;
                }

                if(map.get(gems[left]) == 1) map.remove(gems[left]);
                else map.put(gems[left],map.get(gems[left])-1);
                
                left ++;
                
            }
            
            
            right ++;
            
        }
        
        return result;
        
    }
}