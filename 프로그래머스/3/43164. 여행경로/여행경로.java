import java.util.*;

class Solution {
    
    private String[][] tickets;
    
    private String[] result;
    private boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets,(a,b) -> a[1].compareTo(b[1]));
        
        this.tickets = tickets;
        result = new String[tickets.length + 1];
        result[0] = "ICN";
        
        visited = new boolean[tickets.length];
        dfs("ICN",new ArrayList<>());
            
        return result;
        
    }
    
    private void dfs(String tk, ArrayList<String> routes){
        
        if(routes.size() == tickets.length){
            for(int i = 0; i < routes.size(); i++){
                if(result[i+1] != null) return;
                result[i+1] = routes.get(i);
            }
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(visited[i] || !tickets[i][0].equals(tk)) continue;
            visited[i] = true;
            routes.add(tickets[i][1]);
            dfs(tickets[i][1],routes);
            visited[i] = false;
            routes.remove(routes.size() - 1);
        }
        
    }
}