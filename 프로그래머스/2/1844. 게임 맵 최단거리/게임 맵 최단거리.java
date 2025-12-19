import java.util.*;

class Solution {
    
    private static class Pos{
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0));
        visited[0][0] = true;
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            for(int i = 0; i < size; i++){
                Pos now = deque.poll();
                
                if(now.x == n - 1 && now. y == m - 1) return cnt + 1;
                
                for(int k = 0; k < 4; k++){
                    int mvX = now.x + dx[k];
                    int mvY = now.y + dy[k];
                    
                    if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || visited[mvX][mvY] || maps[mvX][mvY] == 0) continue;
                    deque.add(new Pos(mvX,mvY));
                    visited[mvX][mvY] = true;
                }
            }
            cnt++;
        }
        
        return -1;
        
    }
}