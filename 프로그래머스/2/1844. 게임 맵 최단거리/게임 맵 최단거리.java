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
        return bfs(maps);
    }
    
    private static int bfs(int [][] maps){
        
        int n = maps.length; //row
        int m = maps[0].length;//col
        Pos arrive = new Pos(n-1,m-1); //상대팀 진영
        
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0)); //시작 위치
        
        boolean [][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int cnt = 1;
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Pos mv = deque.poll();
                
                if(mv.x == arrive.x && mv.y == arrive.y) return cnt;
                
                for(int k = 0; k<4; k++){
                    
                    int mvX = mv.x + dx[k];
                    int mvY = mv.y + dy[k];
                    
                    if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || 
                            visited[mvX][mvY] || maps[mvX][mvY] == 0) continue;
                    
                    visited[mvX][mvY] = true;
                    deque.add(new Pos(mvX,mvY));
                }
            }
            
            cnt ++;
            
        }
        
        return -1;
        
    }
}