import java.util.*;

class Solution {
    
    private static int n,m, result;
    
    private static String[] storage;
    private static boolean[][] visited;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    public int solution(String[] storage, String[] requests) {

        n = storage.length;
        m = storage[0].length();
        
        result = n*m;
        
        this.storage = storage;
        visited = new boolean[n][m];
        
        for(String r : requests){
            
            if(r.length() == 1){
                useCar(r.charAt(0));
            }
            else{
                useCrane(r.charAt(0));
            }
            
            //System.out.println(result);
            
        }
        
        return result;
        
    }
    
    private static void useCar(char c){
        
        boolean[][] map = new boolean[n][m];
        
        //테두리 확인(가로)
        for(int i = 0; i < m; i++){
            //가장 위쪽
            if(!map[0][i]) dfs(0,i,c,map);
            //가장 아래쪽
            if(!map[n-1][i]) dfs(n-1,i,c,map);
        }
        
        //테두리 확인(세로)
        for(int i = 0; i < n; i++){
            //가장 왼쪽
            if(!map[i][0]) dfs(i,0,c,map);
            //가장 오른쪽
            if(!map[i][m-1]) dfs(i,m-1,c,map);
        }
        
    }
    
    private static void useCrane(char c){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || storage[i].charAt(j) != c) continue;
                visited[i][j] = true;
                result--;
            }
        }
    }
    
    private static void dfs(int x, int y, char c, boolean[][] map){
        
        map[x][y] = true;
        
        if(!visited[x][y]){
            if(storage[x].charAt(y) == c){
                visited[x][y] = true;
                result--;  
            }
            return;
        }
        
        for(int k = 0; k < 4; k++){
            int mvX = x + dx[k];
            int mvY = y + dy[k];
            
            if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || map[mvX][mvY]) continue;
            map[mvX][mvY] = true;
            dfs(mvX,mvY,c,map);
            
        }
        
    }
    
}