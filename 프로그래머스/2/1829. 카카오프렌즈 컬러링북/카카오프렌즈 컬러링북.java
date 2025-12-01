import java.util.*;

class Solution {
    
    private static boolean[][] visited;
    private static int[][] picture;
    private static int m,n;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        
        this.m = m;
        this.n = n;
        this.picture = picture;
        
        int result = 0;
        int region = 0;
        visited = new boolean[m][n];
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] || picture[i][j] == 0) continue;
                visited[i][j] = true;
                result = Math.max(bfs(i,j,picture[i][j]),result);
                region++;
            }
        }
        
        return new int[]{region,result};
        
    }
    
    private static int bfs(int x, int y, int color){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            int nowX = now[0];
            int nowY = now[1];
            cnt++;
            
            for(int k = 0; k < 4; k++){
                int mvX = nowX + dx[k];
                int mvY = nowY + dy[k];
                
                if(isIn(mvX,mvY,color)) continue;
                deque.add(new int[]{mvX,mvY});
                visited[mvX][mvY] = true;
                
            }
            
        }
        
        return cnt;
        
    }
    
    private static boolean isIn(int x, int y, int color){
        
        if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || picture[x][y] != color) return true;
        return false;
        
    }
    
}