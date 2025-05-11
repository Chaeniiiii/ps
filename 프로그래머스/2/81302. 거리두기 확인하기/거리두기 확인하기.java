import java.util.*;

class Solution {
    
    private static final int SIZE = 5;
    
    private static final int [] dx = {-1,1,0,0};
    private static final int [] dy = {0,0,-1,1};
    
    private static boolean [][] visited;
    
    private static class Pos {
        
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }
    
    public int[] solution(String[][] places) {
        
        int tc = places.length;
        int [] result = new int[tc];
        
        for(int t = 0; t<tc; t++){
            result[t] = simulate(t, places[t]);
        }
        
        return result;
        
    }
    
    private static int simulate(int idx, String [] place){
        
        visited = new boolean[SIZE][SIZE];
        
        for(int i = 0; i<SIZE; i++){
            for(int j = 0; j<SIZE; j++){
                if(place[i].charAt(j) == 'P' && !visited[i][j]){
                    visited[i][j] = true;
                    if(bfs(place,visited,new Pos(i,j)) == 0) return 0;
                }
            }
        }
        
        return 1;
    }
    
    private static int bfs(String [] place, boolean [][] visited, Pos pos){
        
        Deque<Pos> deque = new ArrayDeque<Pos>();
        deque.add(pos);
        
        while(!deque.isEmpty()){
            
            Pos mv = deque.poll();
            
            for(int i = 0; i<4; i++){
                
                int mvX = mv.x + dx[i];
                int mvY = mv.y + dy[i];
                
                if(mvX < 0 || mvY < 0 || mvX >= SIZE || mvY >= SIZE || visited[mvX][mvY] 
                        || place[mvX].charAt(mvY) == 'X') continue;
                if(place[mvX].charAt(mvY) == 'P') return 0;
                
                if(Math.abs(pos.x - mvX) + Math.abs(pos.y - mvY) >= 2) continue;
                
                deque.add(new Pos(mvX,mvY));
                visited[mvX][mvY] = true;
                   
            }
            
        }
        
        return 1;
        
        
    }
    
    
}