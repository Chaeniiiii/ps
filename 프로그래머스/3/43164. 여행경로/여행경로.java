import java.util.*;

class Solution {
    
    private static int len;
    private static String str;

    private static boolean [] visited;
    
    public String[] solution(String[][] tickets) {
        
        len = tickets.length;
        str = null;
        visited = new boolean[len];
        
        dfs(tickets,"ICN",0,"ICN,");
        
        String [] result = str.split(",");
        return result;
        
    }
    
    private static void dfs(String[][] tickets, String st, int dep, String route){
        
        if(dep == len){
            if (str == null || str.compareTo(route) > 0) str = route;
            return;
        }
        
        for(int i = 0; i<len; i++){
            
            if(visited[i] || !tickets[i][0].equals(st)) continue;
            visited[i] = true;
            dfs(tickets,tickets[i][1],dep+1,route+tickets[i][1]+",");
            visited[i] = false;
            
        }
        
    }
    
}