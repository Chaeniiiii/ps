import java.util.*;

class Solution {
    
    private static int col,row;
    
    private static class Pos {
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {

        col = maps[0].length;
        row = maps.length;
        
        return bfs(maps);
        
    }
    
    private static int bfs(int[][] maps){
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0));
        
        int [] dx = new int[]{-1,1,0,0};
        int [] dy = new int[]{0,0,-1,1};
        
        boolean[][] visited = new boolean[row][col];
        
        int cnt = 1;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Pos mv = deque.poll();
                if(mv.x == row-1 && mv.y == col-1) return cnt;
                
                for(int k = 0; k<4; k++){
                    
                    int mvX = mv.x + dx[k];
                    int mvY = mv.y + dy[k];
                    
                    if(mvX < 0 || mvY < 0 || mvX >= row || mvY >= col || 
                        maps[mvX][mvY] == 0 || visited[mvX][mvY]) continue;
                    
                    visited[mvX][mvY] = true;
                    deque.add(new Pos(mvX,mvY));
                    
                }
                
            }
            
            cnt ++;
            
        }
        
        return -1;
        
    }
}