import java.util.*;

class Solution {
    
    private static final int MAX = 10;
    private static int result = 0;
    private static int[] dx = new int[]{-1,0,1,0};
    private static int[] dy = new int[]{0,-1,0,1};
    private static boolean[][][] visited ;
    public int solution(String dirs) {
        
        visited = new boolean[MAX+1][MAX+1][4];
        
        int [] mv = new int[]{5,5};
        for(char c : dirs.toCharArray()){
            
            switch(c){
                case 'U' :
                    mv = move(mv[0],mv[1],0);
                    break;
                case 'D' :
                    mv = move(mv[0],mv[1],2);
                    break;
                case 'L' :
                    mv = move(mv[0],mv[1],1);
                    break;
                case 'R':
                    mv = move(mv[0],mv[1],3);
                    break;
                    
            }
        }
        
        return result;
        
    }
    
    private static int[] move(int x, int y, int dir){
        
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        int other = (dir+2) % 4;
        
        if(!isIn(nx,ny)) return new int[]{x,y};
        if(!visited[x][y][other] && !visited[nx][ny][dir]) result++;
        visited[x][y][other] = visited[nx][ny][dir] = true;
        return new int[]{nx,ny};
        
    }
    
    private static boolean isIn(int x, int y){
        
        if(x < 0 || y < 0 || x > MAX || y > MAX) return false;
        return true;
        
    }
    
}