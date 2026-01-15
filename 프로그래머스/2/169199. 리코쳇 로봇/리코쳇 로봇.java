import java.util.*;

class Solution {
    
    private static int n,m;
    private static int[][] map;
    
    private static Pos st,en;
    
    private static boolean[][][] visited;
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
    
    public int solution(String[] board) {
        
        n = board.length;
        m = board[0].length();
        
        map = new int[n][m];
        visited = new boolean[n][m][4];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                char c = board[i].charAt(j);
                switch(c){
                    case 'D':
                        map[i][j] = 1;
                        break;
                    case 'R':
                        st = new Pos(i,j);
                        break;
                    case 'G':
                        en = new Pos(i,j);
                        break;
                        
                }
            } 
        }
        
        return bfs();
            
    }
    
    private static int bfs(){
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(st);
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();

            for(int i = 0; i < size; i++){
                
                Pos now = deque.poll();
                if(now.x == en.x && now.y == en.y) return cnt;
                
                for(int k = 0; k < 4; k++){
                    int mx = now.x + dx[k];
                    int my = now.y + dy[k];
                    if(mx < 0 || my < 0 || mx >= n || my >= m || map[mx][my] == 1 || visited[mx][my][k]) continue;
                    Pos nxt = go(mx,my,k);
                    deque.add(nxt);
                    
                }
                
            }
            cnt++;
        }
        
        return -1;
        
    }
    
    private static Pos go(int x, int y, int k){
        
        visited[x][y][k] = true;
        while(true){
            int mx = x + dx[k];
            int my = y + dy[k];
            if(mx < 0 || my < 0 || mx >= n || my >= m || map[mx][my] == 1 || visited[mx][my][k]) break;
            x = mx;
            y = my;
            visited[mx][my][k] = true;
        }
        
        return new Pos(x,y);
        
    }
    
    
}