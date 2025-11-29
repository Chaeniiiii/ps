import java.util.*;

class Solution {
    
    private static int result = 0;
    
    private static ArrayList<ArrayList<Integer>> box;
    private static boolean[] visit;
    
    public int solution(int[] cards) {
        
        box = new ArrayList<>();
        
        boolean[] visited = new boolean[cards.length+1];
        
        for(int i = 0; i < cards.length; i++){
            if(visited[i]) continue;
            int now = cards[i] - 1;
            ArrayList<Integer> arr = new ArrayList<>();
            while(!visited[now]){
                visited[now] = true;
                arr.add(now+1);
                now = cards[now] - 1;
            }
            box.add(arr);
        }
        
        if(box.size() <= 1) return 0;
        visit = new boolean[box.size()];
        dfs(0,0,1);
        
        return result;
        
    }
    
    private static void dfs(int dep, int st, int cnt){
        
        if(dep == 2){
            result = Math.max(result,cnt);
            return;
        }
        
        for(int i = st; i < box.size(); i++){
            dfs(dep+1,i+1,cnt*box.get(i).size());
        }
        
    }
    
}