import java.util.*;

class Solution {
    
    private static String str;
    private static boolean[] visited;
    
    private static String[][] tickets;
    
    public String[] solution(String[][] tickets) {
    
        this.tickets = tickets;
        visited = new boolean[tickets.length];
            
        StringBuilder sb = new StringBuilder();
        sb.append("ICN");
        
        dfs(0,"ICN", sb);
        
        String[] result = str.split(",");
            
        return result;
        
    }
    
    private static void dfs(int dep,  String start, StringBuilder sb){
        
        if(dep == tickets.length){
            String path = sb.toString();
            if (str == null || path.compareTo(str) < 0) {
                str = path;
            }
            return;
        }
        
        for(int i = 0 ; i < tickets.length; i++){
            if(!tickets[i][0].equals(start) || visited[i]) continue;
            visited[i] = true;
            int len = sb.length();
            sb.append(",").append(tickets[i][1]);
            dfs(dep+1,tickets[i][1],sb);
            sb.setLength(len);
            visited[i] = false;
        }
        
        
    }
}