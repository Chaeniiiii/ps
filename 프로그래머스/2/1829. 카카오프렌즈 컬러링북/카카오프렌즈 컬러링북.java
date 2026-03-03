import java.util.*;

class Solution {
    
    private static int m,n;
    private static int[][] picture;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};

    private static int[] result;
    private static boolean[][] visited;
    
    private static class Pos{
        int x;
        int y;
        int num;

        private Pos(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
        
    }
    public int[] solution(int m, int n, int[][] picture) {
        
        this.m = m;
        this.n = n;
        this.picture = picture;
        
        result = new int[2];
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] || picture[i][j] == 0) continue;
                visited[i][j] = true;
                result[0]++;
                result[1] = Math.max(bfs(new Pos(i,j,picture[i][j])),result[1]);
            }
        }

        return result;
        
    }
    
    private static int bfs(Pos pos){
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(pos);
        
        int cnt = 1;
        while(!deque.isEmpty()){
            
            Pos now = deque.poll();
            
            for(int k = 0; k < 4; k++){
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny] || picture[nx][ny] != now.num) continue;

                visited[nx][ny] = true;
                deque.add(new Pos(nx,ny,now.num));
                cnt++;
                
            }
            
        }
        
        return cnt;
        
    }
    
}