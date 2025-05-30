import java.util.*;

class Solution {
    
    private static class Pos {
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0));
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int cnt = 1;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Pos mv = deque.poll();
                if(mv.x == n-1 && mv.y == m-1) return cnt;
                
                for(int k = 0; k<4; k++){
                    
                    int mvX = mv.x + dx[k];
                    int mvY = mv.y + dy[k];
                    
                    if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || maps[mvX][mvY] == 0 || visited[mvX][mvY]){
                        continue;
                    }
                    
                    deque.add(new Pos(mvX,mvY));
                    visited[mvX][mvY] = true;
                    
                }
                
            }
            
            cnt++;
            
        }
        
        return -1;
        
    }
}