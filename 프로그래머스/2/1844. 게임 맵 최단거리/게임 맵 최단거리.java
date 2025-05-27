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
        
        int row = maps.length;
        int col = maps[0].length;
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0));
        
        boolean [][] visited = new boolean[row][col];
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        int cnt = 1;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Pos now = deque.poll();
                if(now.x == row-1 && now.y == col-1) return cnt;
                
                for(int k = 0; k<4; k++){
                    
                    int mvX = now.x + dx[k];
                    int mvY = now.y + dy[k];
                       
                    if(mvX <0 || mvY <0 || mvX >=row || mvY >= col || visited[mvX][mvY] || maps[mvX][mvY] == 0) continue;
                    visited[mvX][mvY] = true;
                    deque.add(new Pos(mvX,mvY));
                    
                }
                
            }
            
            cnt++;
            
        }
        
        return -1;
        
    }
}