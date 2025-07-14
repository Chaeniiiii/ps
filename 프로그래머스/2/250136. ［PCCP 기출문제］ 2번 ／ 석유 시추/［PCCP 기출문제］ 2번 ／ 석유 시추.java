import java.util.*;

class Solution {
    
    private static int n,m;
    
    private static int[][] land;
    private static boolean[][] visited;
    
    private static int[] amount;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    private static class Pos{
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
            
        m = land.length; //가로
        n = land[0].length; //세로
        
        this.land = land;
        amount = new int[n];
        visited = new boolean[m][n];
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                bfs(new Pos(i,j));
            }
        }
        
        int result = 0;
        for(int i = 0; i < n ; i++){
            result = Math.max(result, amount[i]);
        }
        
        return result;
        
    }
    
    private static void bfs(Pos st){
        
        int min = st.y;
        int max = st.y;
        int cnt = 1;
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(st);
        
        while(!deque.isEmpty()){
            
            Pos pos = deque.poll();
            
            for(int i = 0; i < 4; i++){
                int mvX = pos.x + dx[i];
                int mvY = pos.y + dy[i];
                
                if(mvX < 0 || mvY < 0 || mvX >= m || mvY >= n || land[mvX][mvY] == 0 || visited[mvX][mvY]) continue;
                
                min = Math.min(mvY,min);
                max = Math.max(mvY,max);
                deque.add(new Pos(mvX,mvY));
                visited[mvX][mvY] = true;
                cnt++;
                
            }
            
        }
        
        getAmount(min, max, cnt);
        
    }
    
    private static void getAmount(int min, int max, int cnt){
        
        for(int i = min; i < max + 1; i++){
            amount[i] += cnt;
        }
        
    }
    
}