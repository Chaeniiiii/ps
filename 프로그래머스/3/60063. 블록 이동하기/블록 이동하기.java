import java.util.*;

class Solution {
    
    private static int n;
    private static int[][] board;
    private static Deque<Robot> deque;
    private static boolean[][][] visited;
    
    private static class Robot{
        
        int x1;
        int y1;
        int x2;
        int y2;
        int d; //0:가로 1:세로
        
        private Robot(int x1, int x2, int y1, int y2, int d){
            
            if(x1 < x2 || (x1 == x2 && y1 < y2)){
                this.x1 = x1;
                this.x2 = x2;
                this.y1 = y1;
                this.y2 = y2;
            }
            else{
                this.x1 = x2;
                this.x2 = x1;
                this.y1 = y2;
                this.y2 = y1;
            }
            this.d = d;
        }
        
    }
    
    public int solution(int[][] board) {
        
        this.board = board;
        n = board.length;
        
        Robot robot = new Robot(0,0,0,1,0);
        
        deque = new ArrayDeque<>();
        deque.add(robot);
        
        visited = new boolean[n][n][2];
        visited[robot.x1][robot.y1][0] = visited[robot.x2][robot.y2][0] = true; 

        int t = 0;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0 ; i < size; i++){
                
                Robot now = deque.poll();
                if(now.x1 == n - 1 && now.y1 == n - 1 || now.x2 == n - 1 && now.y2 == n - 1) return t;
                
                for(int k = 0; k < 4; k++){
                    
                    int mx1 = now.x1 + dx[k];
                    int mx2 = now.x2 + dx[k];

                    int my1 = now.y1 + dy[k];
                    int my2 = now.y2 + dy[k];
                    
                    if(!isIn(mx1,my1) || !isIn(mx2,my2) || (visited[mx1][my1][now.d] && visited[mx2][my2][now.d])) continue;
                    
                    deque.add(new Robot(mx1,mx2,my1,my2,now.d));
                    visited[mx1][my1][now.d] = true;
                    visited[mx2][my2][now.d] = true;
                    
                }
                
                //세로 검증
                if(now.d == 0) rotateCol(now);
                //가로 검증
                if(now.d == 1) rotateRow(now);
                
            }
            
            t++;
            
        }
        
        return -1;
        
    }
    
    private static boolean isIn(int x, int y){
        
        if(x < 0 || y < 0 || x >= n || y >= n || board[x][y] == 1) return false;
        return true;
        
    }
    
    private static void rotateCol(Robot now){
        
        int x1 = now.x1;
        int x2 = now.x2;
        int y1 = now.y1;
        int y2 = now.y2;
        
        //위쪽 검증
        if(isIn(x1 - 1,y1) && isIn(x2 - 1, y2)){
            
            if(!visited[x1][y1][1] || !visited[x1 - 1][y1][1]){
                deque.add(new Robot(x1,x1-1,y1,y1,1));
                visited[x1][y1][1] = visited[x1 - 1][y1][1] = true;
            }
            if(!visited[x2][y2][1] || !visited[x2-1][y2][1]){
                deque.add(new Robot(x2,x2-1,y2,y2,1));
                visited[x2][y2][1] = visited[x2 - 1][y2][1] = true;
            }
            
        }
        
        //아래쪽 검증
        if(isIn(x1 + 1, y1) && isIn(x2 + 1, y2)){
            if(!visited[x1][y1][1] || !visited[x1 + 1][y1][1]){
                deque.add(new Robot(x1,x1 + 1,y1,y1,1));
                visited[x1][y1][1] = visited[x1 + 1][y1][1] = true;
            }
            if(!visited[x2][y2][1] || !visited[x2 + 1][y2][1]){
                deque.add(new Robot(x2,x2 + 1, y2,y2,1));
                visited[x2][y2][1] = visited[x2 + 1][y2][1] = true;
            }
        }
            
        
        
    }
    
    private static void rotateRow(Robot now){
        
        //왼쪽 검증
        if(isIn(now.x1, now.y1 - 1) && isIn(now.x2,now.y2 - 1)){
            if(!visited[now.x1][now.y1][0] || !visited[now.x1][now.y1 - 1][0]){
                deque.add(new Robot(now.x1,now.x1, now.y1, now.y1 - 1, 0));
                visited[now.x1][now.y1][0] = visited[now.x1][now.y1 - 1][0] = true;
            }
            if(!visited[now.x2][now.y2][0] || !visited[now.x2][now.y2 - 1][0]){
                deque.add(new Robot(now.x2, now.x2, now.y2, now.y2 - 1, 0));
                visited[now.x2][now.y2][0] = visited[now.x2][now.y2 - 1][0] = true;
            }
        }
        
        //오른쪽 검증
        if(isIn(now.x1, now.y1 + 1) && isIn(now.x2, now.y2 + 1)){
            if(!visited[now.x1][now.y1][0] || !visited[now.x1][now.y1 + 1][0]){
                deque.add(new Robot(now.x1,now.x1, now.y1, now.y1 + 1, 0));
                visited[now.x1][now.y1][0] = visited[now.x1][now.y1 + 1][0] = true;
            }
            if(!visited[now.x2][now.y2][0] || !visited[now.x2][now.y2 + 1][0]){
                deque.add(new Robot(now.x2, now.x2, now.y2, now.y2 + 1, 0));
                visited[now.x2][now.y2][0] = visited[now.x2][now.y2 + 1][0] = true;
            }
        }
        
    }
}