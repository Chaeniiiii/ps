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
    
    public int solution(String[] maps) {
        
        Deque<Pos> deque = new ArrayDeque<>();
        Pos start = new Pos(-1,-1);
        Pos end = new Pos(-1,-1);
        Pos laber = new Pos(-1,-1);
    
        for(int i = 0; i<maps.length; i ++){
            for(int j = 0; j<maps[i].length(); j++){
                char c = maps[i].charAt(j);
                switch(c){
                    case 'S' :
                        start = new Pos(i,j);
                        break;
                    case 'E' :
                        end = new Pos(i,j);
                        break;
                    case 'L' :
                        laber = new Pos(i,j);
                        break;
                }
            }
        }
        
        //start -> laber
        
        int cnt = 0;
            
        int firstStep = bfs(start,laber,maps) ;
        if(firstStep == -1) return -1;
        
        cnt+=firstStep;
        
        //laber -> end
        int scdStep = bfs(laber,end,maps) ;
        if(scdStep == -1) return -1;
        
        cnt+=scdStep;
        
        return cnt;
        
    }
    
    private static int bfs(Pos go, Pos arrive, String [] map){
        
        int row = map.length;
        int col = map[0].length();
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(go);
        
        boolean [][] visited = new boolean[row][col];
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        
        int t = 0;
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Pos mv = deque.poll();
                if(mv.x == arrive.x && mv.y == arrive.y) return t;
                
                for(int k = 0; k<4; k++){
                    
                    int mvX = mv.x + dx[k];
                    int mvY = mv.y + dy[k];
                    
                    if(mvX <0 || mvY < 0 || mvX >= row || mvY >= col || visited[mvX][mvY] 
                                || map[mvX].charAt(mvY) == 'X') continue;
                    
                    visited[mvX][mvY] = true;
                    deque.add(new Pos(mvX,mvY));
                    
                }
                
            }
            
            t++;
            
        }
        
        return -1;
        
    }
    
    
}