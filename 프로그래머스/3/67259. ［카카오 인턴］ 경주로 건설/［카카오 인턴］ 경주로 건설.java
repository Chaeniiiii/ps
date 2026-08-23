import java.util.*;

class Solution {
    
    private class Pos{
        
        int x;
        int y;
        int d;
        int c;
        
        private Pos(int x, int y, int d, int c){
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
        
    }
    
    public int solution(int[][] board) {
        
        int n = board.length;
        int cost = Integer.MAX_VALUE;
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0,0,0));
        deque.add(new Pos(0,0,2,0));
        
        int[][][] dp = new int[n][n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = dp[0][0][3] = 0;
        
        while(!deque.isEmpty()){
            
            Pos now = deque.poll();
            if(now.x == n - 1 && now.y == n - 1){
                cost = Math.min(cost,now.c);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                
                boolean nowd = now.d <= 1 ? true : false;
                boolean nxtd = i <= 1 ? true : false;
                boolean type = nowd == nxtd ? true : false;
                int nxtc = now.c;
                
                if(mx < 0 || my < 0 || mx >= n || my >= n || board[mx][my] == 1 || dp[mx][my][i] <= now.c) continue;

                if(type) nxtc += 100;
                else nxtc += 600;
                
                deque.add(new Pos(mx,my,i,nxtc));
                dp[mx][my][i] = nxtc;

                
            }
            
        }
        
        return cost;
        
    }
}