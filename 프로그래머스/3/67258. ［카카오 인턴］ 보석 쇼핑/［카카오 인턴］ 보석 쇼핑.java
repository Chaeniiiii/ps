import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        Map<String,Integer> map = new HashMap<>();
        int lt = 0, rt = lt;
        int minLen = gems.length;
        
        for(; rt < gems.length; rt++){
            
            map.put(gems[rt],map.getOrDefault(gems[rt],0)+1);
            
            while(map.keySet().size() == set.size()){
                
                if(minLen > rt - lt){
                    minLen = rt - lt;
                }
                
                if(lt < gems.length - 1 && map.get(gems[lt+1]) > 0){
                    lt++;
                    if(map.get(gems[lt]) == 1) map.remove(gems[lt]);
                    else map.put(gems[lt],map.get(gems[lt])-1);
                }
                else break;
            }
            
        }
        
        return new int[]{lt+1,rt};
        
    }
}