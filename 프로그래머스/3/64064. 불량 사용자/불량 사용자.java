import java.util.*;

class Solution {

    private String[] user_id, banned_id;
    private boolean[] visited;
    private Set<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        set = new HashSet<>();
        visited = new boolean[user_id.length];
        dfs(0,new ArrayList<>());
        
        return set.size();
        
    }
    
    private void dfs(int bndIdx, ArrayList<String> arr){
        
        if(bndIdx == banned_id.length){
            
            ArrayList<String> newArr = new ArrayList<>(arr);
            newArr.sort((a,b) -> a.compareTo(b));
            StringBuilder sb = new StringBuilder();
            
            for(String str : newArr){
                sb.append(str);
            }
            
            if(set.contains(sb.toString())) return;
            set.add(sb.toString());
            
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if(visited[i] || !isPossible(user_id[i],banned_id[bndIdx])) continue;
            visited[i] = true;
            arr.add(user_id[i]);
            dfs(bndIdx+1,arr);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }
        
    }
    
    private boolean isPossible(String a, String b){
        
        if(a.length() != b.length()) return false;
        
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i)) return false;
        }
        
        return true;
        
    }
}