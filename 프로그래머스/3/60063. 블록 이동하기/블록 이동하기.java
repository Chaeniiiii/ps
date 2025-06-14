import java.util.*;

class Solution {

    private static int n,m;
    private static int[][] board;
    
    private static class Robot{
        
        Pos st;
        Pos en;
        int dir;
        
        private Robot(Pos st, Pos en, int dir){
            if(st.x < en.x || (st.x == en.x && st.y < en.y)){
                this.st = st;
                this.en = en;
            }
            else{
                this.st = en;
                this.en = st;
            }
            this.dir = dir;
        }
    }
    
    private static class Pos{ 
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] board) {
        
        this.board = board;
        
        n = board.length;
        m = board[0].length;
        
        ArrayDeque<Robot> deque = new ArrayDeque<>();
        deque.add(new Robot(new Pos(0,0),new Pos(0,1),0));
        
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;
        visited[0][1][0] = true;
        
        int cnt = 0;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i < size; i++){
                
                Robot rb = deque.poll();
                
                Pos st = rb.st;
                Pos en = rb.en;
                int dir = rb.dir;
                
                if((st.x == n - 1 && st.y == m - 1) || (en.x == n - 1 && en.y == m - 1)){
                    return cnt;
                }
                
                //상하좌우 이동
                for(int k = 0; k < 4; k++){
                    
                    int mx1 = st.x + dx[k];
                    int my1 = st.y + dy[k];
                    
                    int mx2 = en.x + dx[k];
                    int my2 = en.y + dy[k];
                    
                    if(!isIn(mx1,my1) || !isIn(mx2,my2) || (visited[mx1][my1][dir] && visited[mx2][my2][dir])){
                        continue;
                    }
                    
                    deque.add(new Robot(new Pos(mx1,my1),new Pos(mx2,my2),dir));
                    
                    visited[mx1][my1][dir] = true;
                    visited[mx2][my2][dir] = true;
                    
                }
                
                //90도 회전
                ArrayList<Robot> rotatePos = dir == 0 ? rotateRow(st,en) : rotateCol(st,en);
                for(Robot newRb : rotatePos){
                    
                    Pos nSt = newRb.st;
                    Pos nEn = newRb.en;
                    int nDir = newRb.dir;
                    
                    if(visited[nSt.x][nSt.y][nDir] && visited[nEn.x][nEn.y][nDir]){
                        continue;
                    }
                    
                    deque.add(new Robot(nSt,nEn,nDir));
                    visited[nSt.x][nSt.y][nDir] = true;
                    visited[nEn.x][nEn.y][nDir] = true;
                    
                }
            }
            cnt++;
            
        }
        
        return cnt;
        
    }
    
    private static boolean isIn(int x, int y){
        
        if(x < 0 || y < 0 || x >= n || y >= m || board[x][y] == 1){
            return false;
        }
        
        return true;
        
    }
    
    //기존 로봇의 방향 : 가로 
    private static ArrayList<Robot> rotateRow(Pos st, Pos en){
        
        ArrayList<Robot> result = new ArrayList<>();
        
        //상단으로 회전
        if(isIn(st.x - 1, st.y) && isIn(en.x - 1, en.y)){
            result.add(new Robot(new Pos(st.x - 1, st.y),st,1));
            result.add(new Robot(new Pos(en.x - 1, en.y),en,1));
        }
        //하단으로 회전
        if(isIn(st.x + 1, st.y) && isIn(en.x + 1, en.y)){
            result.add(new Robot(new Pos(st.x + 1, st.y),st,1));
            result.add(new Robot(new Pos(en.x + 1, en.y),en,1));
        }
        
        return result;
        
    }
    
    //기존 로봇의 방향 : 세로 
    private static ArrayList<Robot> rotateCol(Pos st, Pos en){
     
        ArrayList<Robot> result = new ArrayList<>();
        
        //좌측으로 회전
        if(isIn(st.x, st.y - 1) && isIn(en.x, en.y - 1)){
            result.add(new Robot(new Pos(st.x,st.y - 1),st,0));
            result.add(new Robot(new Pos(en.x,en.y - 1),en,0));
        }
        //우측으로 회전
        if(isIn(st.x, st.y + 1) && isIn(en.x, en.y + 1)){
            result.add(new Robot(new Pos(st.x,st.y + 1),st,0));
            result.add(new Robot(new Pos(en.x,en.y + 1),en,0));
        }
        
        return result;
        
    }
    
}