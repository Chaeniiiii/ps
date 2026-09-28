import java.util.*;

class Solution {
    
    private class Pos{
        int x;
        int y;
        StringBuilder sb;
        
        private Pos(int x, int y, StringBuilder sb){
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
        
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }
        
        int[] dx = new int[]{1,0,0,-1};
        int[] dy = new int[]{0,-1,1,0};
        char[] d = new char[]{'d','l','r','u'};
        
        StringBuilder sb = new StringBuilder();
        int curX = x;
        int curY = y;
        
        for(int i = 0; i < k; i++){
            
            int remain = k - i - 1;
            
            for(int j = 0; j < 4; j++){
                
                int nx = curX + dx[j];
                int ny = curY + dy[j];
                
                if(nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                int remainDist = Math.abs(r - nx) + Math.abs(c - ny);
                
                if(remainDist <= remain && (remain - remainDist) % 2 == 0){
                    sb.append(d[j]);
                    curX = nx;
                    curY = ny;
                    break;
                }
                
            }
            
        }
                
        return sb.toString();
        
    }
   
}