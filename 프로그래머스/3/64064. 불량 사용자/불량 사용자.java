import java.util.*;

class Solution {
    
    private static boolean [] visited;
    private static Set<HashSet<String>> set;
    
    public int solution(String[] userId, String[] bannedId) {
        
        set = new HashSet<>();
        
        dfs(new HashSet<>(),0,userId,bannedId);
        
        return set.size();
        
    }
    
    private static void dfs(HashSet<String> id, int dep, String[] userId, String[] bannedId){
        
        if(dep == bannedId.length){
            set.add(id);
            return;
        }
        
        for(int i = 0; i<userId.length; i++){
            if(id.contains(userId[i])) continue;
            
            if(possible(userId[i],bannedId[dep])){
                id.add(userId[i]);
                dfs(new HashSet<>(id),dep+1,userId,bannedId);
                id.remove(userId[i]);
            }
        }
        
    }
    
    private static boolean possible(String userId, String bannedId){
        
        if(userId.length() != bannedId.length()) return false;
        
        for(int i = 0; i<userId.length(); i++){
            
            if(bannedId.charAt(i) == '*') continue;
            if(userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        
        return true;
        
    }
}