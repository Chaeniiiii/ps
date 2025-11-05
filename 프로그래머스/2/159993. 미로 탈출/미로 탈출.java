import java.util.*;

class Solution {
    
    private static Pos st,en,lb;
    
    private static class Pos{
        int x;
        int y;
        int open;
        
        private Pos(int x, int y, int open){
            this.x = x;
            this.y = y;
            this.open = open;
        }
    }
    
    public int solution(String[] maps) {
        
        int n = maps.length;
        int m = maps[0].length();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char s = maps[i].charAt(j);
                switch(s){
                    case 'S':
                        st = new Pos(i,j,0);
                        break;
                    case 'E':
                        en = new Pos(i,j,0);
                        break;
                    case 'L':
                        lb = new Pos(i,j,1);
                        break;
                    default:
                        break;
                }
            }
        }
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(st);
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        int cnt = 0;
        
        boolean[][][] visited = new boolean[n][m][2];
        visited[st.x][st.y][0] = true;
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i < size; i++){
                
                Pos pos = deque.poll();
                if(pos.x == lb.x && pos.y == lb.y) pos.open = 1;
                if(pos.x == en.x && pos.y == en.y && pos.open == 1) return cnt;
                
                for(int k = 0 ; k < 4; k++){
                    int mvX = pos.x + dx[k];
                    int mvY = pos.y + dy[k];
                    
                    if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || visited[mvX][mvY][pos.open] || maps[mvX].charAt(mvY) == 'X') continue;
                    deque.add(new Pos(mvX,mvY,pos.open));
                    visited[mvX][mvY][pos.open] = true;
                    
                }
                
            }
            
            cnt++;
            
        }
        
        return -1;
        
    }
}