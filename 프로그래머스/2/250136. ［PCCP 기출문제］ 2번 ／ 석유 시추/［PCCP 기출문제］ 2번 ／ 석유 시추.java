import java.util.*;

class Solution {
    
    private static int n,m;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    private static int[] oil;
    private static int[][] land;
    private static boolean[][] visited;
    
    public int solution(int[][] land) {
        
        this.land = land;
        n = land.length;
        m = land[0].length;
        
        oil = new int[m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || land[i][j] == 0) continue;
                visited[i][j] = true;
                bfs(i,j);
            }
        }
        
        Arrays.sort(oil);
        return oil[m-1];
        
    }
    
    private static void bfs(int x, int y){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        int cnt = 0;
        boolean[] oilVisited = new boolean[m];
        oilVisited[y] = true;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            cnt++;
            
            for(int k = 0; k < 4; k++){
                
                int mvX = now[0] + dx[k];
                int mvY = now[1] + dy[k];
                
                if(isIn(mvX,mvY)) continue;
                deque.add(new int[]{mvX,mvY});
                visited[mvX][mvY] = true;
                oilVisited[mvY] = true;
                
            }
            
        }
        
        for(int i = 0; i < m; i++){
            if(oilVisited[i]) oil[i] += cnt;
        }
        
    }
    
    private static boolean isIn(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m || land[x][y] == 0 || visited[x][y]) return true;
        return false;
    }
    
}