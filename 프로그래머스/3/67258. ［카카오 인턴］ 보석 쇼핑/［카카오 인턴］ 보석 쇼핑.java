import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int[] result = new int[]{0,gems.length-1};
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        Map<String,Integer> map = new HashMap<>();
        int lt = 0, rt = 0;
        
        while(lt <= rt && rt < gems.length){
            
            map.put(gems[rt],map.getOrDefault(gems[rt],0)+1);
            
            while(map.size() == set.size()){
                if(result[1] - result[0] > rt - lt){
                    result[1] = rt;
                    result[0] = lt;
                }
                if(map.getOrDefault(gems[lt],1) == 1) map.remove(gems[lt]);
                else map.put(gems[lt],map.get(gems[lt]) - 1);
                
                lt++;
            }
            
            rt++;
                
        }
        
        result[0]++;
        result[1]++;
        return result;
        
    }
}