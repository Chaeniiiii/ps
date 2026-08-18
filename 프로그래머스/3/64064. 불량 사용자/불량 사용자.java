import java.util.*;

class Solution {
    
    private String[] uId, bId;
    private int cnt;
    
    private boolean[] visited;
    private Map<String,Integer> map;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        cnt = 0;
        this.uId = user_id;
        this.bId = banned_id;
        
        map = new HashMap<>();
        visited = new boolean[uId.length];
        
        dfs(0, new int[bId.length]);
        
        return cnt;
        
    }
    
    private void dfs(int dep, int[] arr){
        
        if(dep == bId.length){
            
            int[] newArr = arr.clone();
            Arrays.sort(newArr);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++) sb.append(newArr[i]);
            
            if(map.getOrDefault(sb.toString(),0) == 0){
                map.put(sb.toString(),1);
                cnt++;
            }
            
            return;
            
        }
        
        for(int i = 0; i < uId.length; i++){
            if(visited[i]) continue;
            if(isPossible(bId[dep],uId[i])){
                visited[i] = true;
                arr[dep] = i;
                dfs(dep+1,arr);
                visited[i] = false;
            }
        }
        
    }
    
    private boolean isPossible(String now, String target){
        
        if(now.length() != target.length()) return false;
        
        for(int i = 0; i < now.length(); i++){
            if(now.charAt(i) == '*') continue;
            if(now.charAt(i) != target.charAt(i)) return false;
        }
        
        return true;
        
    }
}