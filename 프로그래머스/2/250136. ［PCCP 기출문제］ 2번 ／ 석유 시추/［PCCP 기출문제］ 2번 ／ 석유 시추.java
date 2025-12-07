import java.util.*;

class Solution {
    
    private static int n,m;
    private static int[] amount;
    private static boolean[][] visited;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        
        amount = new int[m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                bfs(i,j,land);
            }
        }
        
        Arrays.sort(amount);
        return amount[m-1];
        
    }
    
    private static void bfs(int x, int y, int[][] land){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        int min = y;
        int max = y;
        int cnt = 0;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            cnt++;
            
            for(int i = 0; i < 4; i++){
                int mvX = now[0] + dx[i];
                int mvY = now[1] + dy[i];
                
                if(!isIn(mvX,mvY) || land[mvX][mvY] == 0) continue;
                visited[mvX][mvY] = true;
                deque.add(new int[]{mvX,mvY});
                
                min = Math.min(min,mvY);
                max = Math.max(max,mvY);
                
            }
            
        }
        
        for(int i = min; i <= max; i++){
            amount[i] += cnt;
        }
        
    }
    
    private static boolean isIn(int x, int y){
        
        if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) return false;
        return true;
        
    }
    
}