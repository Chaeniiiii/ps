import java.util.*;

class Solution {
    
    private static final int SIZE = 100;
    
    private static final int [] dx = {-1,1,0,0};
    private static final int [] dy = {0,0,-1,1};
    
    private static int answer;
    private static int col,row;
    
    private static class Pos {
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        
        row = maps.length;
        col = maps[0].length();
        
        Pos st = new Pos(-1,-1);
        Pos en = new Pos(-1,-1);
        Pos lb = new Pos(-1,-1);
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                char c = maps[i].charAt(j);
                if(c == 'S') st = new Pos(i,j);
                else if(c == 'E') en = new Pos(i,j);
                else if(c == 'L') lb = new Pos(i,j);
            }
        }
        
        answer = 0;
        
        if(!bfs(st,lb,maps)) return -1;
        if(!bfs(lb,en,maps)) return -1;
        
        return answer;
        
    }
    
    private static boolean bfs(Pos a, Pos b, String [] maps){
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(a);
        
        boolean [][] visited = new boolean[row][col];
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            if(answer > SIZE * SIZE) return false;
            
            for(int t = 0; t<size; t++){
                
                Pos mv = deque.poll();
                if(mv.x == b.x && mv.y == b.y) return true;
                
                for(int i = 0; i<4; i++){

                    int mvX = mv.x + dx[i];
                    int mvY = mv.y + dy[i];

                    if(mvX < 0 || mvY < 0 || mvX >= row || mvY >= col || visited[mvX][mvY] ||
                        maps[mvX].charAt(mvY) == 'X') continue;
                    
                    deque.add(new Pos(mvX,mvY));
                    visited[mvX][mvY] = true;
                    
                }
            }
            
            answer ++;
            
        }
        
        return false;
        
    }
}