import java.util.*;

class Solution {
    
    private static int n,m,result;
    private static Pos st, en, lb;
    private static int[][] board;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    private static class Pos{
        int x,y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        board = new int[n][m];
            
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char c = maps[i].charAt(j);
                switch(c){
                    case 'S':
                        board[i][j] = -1;
                        st = new Pos(i,j);
                        break;
                    case 'E':
                        board[i][j] = -1;
                        en = new Pos(i,j);
                        break;
                    case 'L':
                        board[i][j] = 2;
                        lb = new Pos(i,j);
                        break;
                    case 'O':
                        board[i][j] = 0;
                        break;
                    case 'X':
                        board[i][j] = 1;
                        break;
                }
            }
        }
        
        result = 0;
        if(bfs(st,lb) == -1) return -1;
        if(bfs(lb,en) == -1) return -1;
        
        return result;
        
    }
    
    private static int bfs(Pos start, Pos end){
        
        int pass = 0;
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(start);
        
        boolean[][] visited = new boolean[n][m];
        visited[start.x][start.y] = true;
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            for(int i = 0 ; i < size; i++){
                
                Pos now = deque.poll();
                if(now.x == end.x && now.y == end.y) return result;
                
                for(int k = 0 ; k < 4; k++){
                    int mx = now.x + dx[k];
                    int my = now.y + dy[k];
                    
                    if(mx < 0 || my < 0 || mx >= n || my >= m || 
                        visited[mx][my] || board[mx][my] == 1) continue;
                    visited[mx][my] = true;
                    deque.add(new Pos(mx,my));
                    
                }
            }
            
            result++;
            
        }
        
        return -1;
        
    }
}