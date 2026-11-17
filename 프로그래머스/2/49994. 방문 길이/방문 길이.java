import java.util.*;

class Solution {
    
    private final int SIZE = 11;
    
    public int solution(String dirs) {
        
        int result = 0;
        boolean[][][] visited = new boolean[SIZE][SIZE][4];
        
        int[] now = new int[]{5,5};
        for(char c : dirs.toCharArray()){
            
            int x = now[0];
            int y = now[1];
            
            switch(c){
                case 'U':
                    if(x - 1 < 0) break;
                    x--;
                    if(visited[x][y][0]) break;
                    visited[x][y][0] = true;                                        
                    visited[x+1][y][1] = true;  
                    result++;
                    break;
                case 'D':
                    if(x + 1 >= SIZE) break;
                    x++;
                    if(visited[x][y][1]) break;
                    visited[x][y][1] = true;   
                    visited[x-1][y][0] = true;   
                    result++;
                    break;
                case 'R':
                    if(y + 1 >= SIZE) break;
                    y++;
                    if(visited[x][y][2]) break;
                    visited[x][y][2] = true;   
                    visited[x][y-1][3] = true;   
                    result++;
                    break;
                case 'L':
                    if(y - 1 < 0) break;
                    y--;
                    if(visited[x][y][3]) break;
                    visited[x][y][3] = true;     
                    visited[x][y+1][2] = true;   
                    result++;
                    break;
            }
            now[0] = x;
            now[1] = y;
        }
        
        return result;
        
    }
    
    
}