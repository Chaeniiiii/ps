import java.util.*;

class Solution {
    
    private static int n, m;
    private static char[][] map;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        
        int startX = 0, startY = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(startX, startY);
    }
    
    private int bfs(int sx, int sy){
        
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        deque.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];
            
            if(map[x][y] == 'G') return cnt;
            
            for(int k=0;k<4;k++){
                int nx = x;
                int ny = y;
                
                while(true){
                    int tx = nx + dx[k];
                    int ty = ny + dy[k];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) break;
                    if(map[tx][ty] == 'D') break;
                    nx = tx; ny = ty;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny, cnt+1});
                }
            }
        }
        return -1;
    }
}
