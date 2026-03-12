import java.util.*;

class Solution {
    
    private int row, col;
    
    private int[] size;
    private int[][] land;
    private boolean[][] visited;
    
    private int[] dx = new int[]{-1,1,0,0};
    private int[] dy = new int[]{0,0,-1,1};
    
    public int solution(int[][] land) {
        
        row = land.length;
        col = land[0].length;

        this.land = land;
        size = new int[col];
        visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(land[i][j] == 0 || visited[i][j]) continue;
                bfs(i,j);                
            }
        }
        
        int result = 0;
        for(int i = 0; i < col; i++){
            result = Math.max(result,size[i]);
        }
        
        return result;
        
    }
    
    private void bfs(int x, int y){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        visited[x][y] = true;
        
        int min = y, max = y, cnt = 1;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            
            for(int k = 0; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= row || ny >= col || land[nx][ny] == 0 || visited[nx][ny]) continue;
                deque.add(new int[]{nx,ny});
                visited[nx][ny] = true;
                min = Math.min(min,ny);
                max = Math.max(max,ny);
                cnt++;
            }
            
        }
        
        for(int i = min; i <= max; i++){
            size[i] += cnt;
        }
        
    }
}