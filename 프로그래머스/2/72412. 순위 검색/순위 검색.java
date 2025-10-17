import java.util.*;

class Solution {
    
    private static Map<String,ArrayList<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
    
        int[] result = new int[query.length];
        map = new HashMap<>();
        
        for(int i = 0; i < info.length; i++){
            
            String[] str = info[i].split(" ");
            dfs(0,"",str);
            
        }
        
        for(String key : map.keySet()){
            map.get(key).sort((a,b) -> a - b);
        }
        
        for(int i = 0; i < query.length; i++){
            
            String q = query[i].replaceAll(" and ","");
            String[] scoreStr = q.split(" ");
            
            q = scoreStr[0];
            int score = Integer.parseInt(scoreStr[1]);
            
            if(!map.containsKey(q)){
                result[i] = 0;
                continue;
            }
            
            int lt = 0, rt = map.get(q).size() - 1;
            
            while(lt <= rt){
                
                int mid = (lt + rt) / 2;
                
                if(map.get(q).get(mid) >= score){
                    rt = mid - 1;
                }
                else{
                    lt = mid + 1;
                }
            }
            
            result[i] = map.get(q).size() - lt;
            
        }
        
        return result;
        
    }
    
    private static void dfs(int dep, String key, String[] str){
        
        if(dep == 4){
            map.computeIfAbsent(key, v -> new ArrayList<>()).add(Integer.parseInt(str[4]));        
            return;
        }
        
        dfs(dep+1,key+str[dep],str);
        dfs(dep+1,key+"-",str);
        
    }
}