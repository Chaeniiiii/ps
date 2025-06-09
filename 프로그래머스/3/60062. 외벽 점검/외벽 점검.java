import java.util.*;

class Solution {
    
    private static final int MAX = Integer.MAX_VALUE;
    
    private static int[] Weak,Dist;
    private static int result;
    
    public int solution(int n, int[] weak, int[] dist) {
        
        result = MAX;
        Weak = weak;
        Dist = dist;
        
        for(int i = 0; i < weak.length; i++){
            simulation(n,1,i,new boolean[weak.length]);
        }
        
        return result == MAX ? -1 : result;
        
    }
    
    private static void simulation(int n, int dep, int pos, boolean[] visited){
        
        if(dep > Dist.length || result <= dep){
            return;
        }
        
        boolean[] newVisited = Arrays.copyOf(visited,visited.length);
        for(int i = 0; i < Weak.length; i++){
            int next = (pos + i) % Weak.length;
            int diff = next >= pos ? Weak[next] - Weak[pos] : Weak[next] + n - Weak[pos];
            
            if(diff <= Dist[Dist.length - dep]){
                newVisited[next] = true;
            }
            else{
                break;
            }
        }
        
        if(isValid(newVisited)){
            result = Math.min(result,dep);
            return;
        }
        
        for(int i = 0; i < Weak.length; i++){
            if(!newVisited[i]){
                simulation(n,dep+1,i,newVisited);
            }
        }
        
    }
    
    private static boolean isValid(boolean[] visit){
        for(int i = 0; i < visit.length; i++){
            if(!visit[i]){
                return false;
            }
        }
        return true;
    }
    
}