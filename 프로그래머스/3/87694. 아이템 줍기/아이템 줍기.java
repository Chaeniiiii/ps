import java.util.*;

class Solution {
    
    private static int[][] map = new int[101][101];
    private static boolean[][] visited = new boolean[101][101];
    private static Deque<player> deque;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int answer = Integer.MAX_VALUE;
    
    private static class player
    {
        int x;
        int y;
        int move;
        
        public player(int x, int y, int move)
        {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        deque = new ArrayDeque<>();
        deque.add(new player(2*characterX, 2*characterY, 0)); 
        
        for(int i = 0 ; i < rectangle.length ; i++)
        {
            int lx = rectangle[i][0]*2;
            int ly = rectangle[i][1]*2;
            int rx = rectangle[i][2]*2;
            int ry = rectangle[i][3]*2;
            
            for(int j = ry ; j >= ly ; j--)
            {
                for(int k = rx ; k >= lx ; k--)
                {
                    if(map[j][k] == 2) continue;
                    
                    map[j][k] = 2;
                    
                    if(j == ly || j == ry || k == lx || k == rx)
                        map[j][k] = 1;
                }
                
            }
        }
                           
        bfs(2*itemX, 2*itemY);
        
        return answer/2;
    }
    
    public static void bfs(int x, int y){
        
        while(!deque.isEmpty())
        {
            player p = deque.poll();
            
            if(p.x == x && p.y == y)
            {
                answer = Math.min(answer, p.move);
                return;
            }
            
            if(visited[p.y][p.x] || map[p.y][p.x] != 1) continue;
            visited[p.y][p.x] = true;
            
            for(int i = 0 ; i < 4 ; i++)
            {
                int mvX = p.x + dx[i];
                int mvY = p.y + dy[i];
                
                if(mvX < 0 || mvY < 0 || mvX > 100 || mvY > 100) continue;

                deque.add(new player(mvX, mvY, p.move+1));
            }
        }
    }
}