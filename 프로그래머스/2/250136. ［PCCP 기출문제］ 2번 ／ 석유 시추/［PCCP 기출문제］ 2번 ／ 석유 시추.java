import java.util.*;

class Solution {
    
    private static int n,m;
    private static int[] amount;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    private static boolean[][] visited;
    
    private static class Pos{
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        
        amount = new int[m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || land[i][j] == 0) continue;
                visited[i][j] = true;
                bfs(land, new Pos(i,j));
            }
        }
        
        int maxAmount = 0;
        
        for(int i = 0; i < m; i++){
            maxAmount = Math.max(maxAmount,amount[i]);
        }
        
        return maxAmount;
        
    }
    
    private static void bfs(int[][] land, Pos pos){
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(pos);
        
        int[] result = new int[2];
        Arrays.fill(result,pos.y);
        
        int cnt = 1;
        while(!deque.isEmpty()){
            
            Pos now = deque.poll();
            
            for(int i = 0; i < 4; i++){
                
                int mvX = now.x + dx[i];
                int mvY = now.y + dy[i];
                
                if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || visited[mvX][mvY] || land[mvX][mvY] == 0) continue;
                
                result[0] = Math.min(result[0],mvY);
                result[1] = Math.max(result[1],mvY);
                
                deque.add(new Pos(mvX,mvY));
                visited[mvX][mvY] = true;
                cnt++;
                
            }
             
        }
        
        getOil(result,cnt);
        
    }
    
    private static void getOil(int[] result, int cnt){
        
        if(result[0] == result[1]){
            amount[result[0]] += cnt;
            return;
        }
        
        for(int i = result[0]; i <= result[1]; i++){
            amount[i] += cnt;
        }
        
    }
    
}