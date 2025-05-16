import java.util.*;

public class Solution {
    
    private static int n;
    
    private static final int [] dx = new int[]{1,-1,0,0}; 
    private static final int [] dy = new int[]{0,0,-1,1};
        
    private static Set<Robot> visited;
    
    private static class Robot {
        Pos st;
        Pos en;
        boolean dir;
        
        private Robot(Pos st, Pos en, boolean dir){
            if (st.x < en.x || (st.x == en.x && st.y < en.y)) {
                this.st = st;
                this.en = en;
            } else {
                this.st = en;
                this.en = st;
            }
            this.dir = dir;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Robot robot = (Robot) obj;
            return dir == robot.dir &&
                   st.equals(robot.st) &&
                   en.equals(robot.en);
        }

        @Override
        public int hashCode() {
            int result = st.hashCode();
            result = 31 * result + en.hashCode();
            result = 31 * result + (dir ? 1 : 0);
            return result;
        }
    }
    
    private static class Pos {
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pos pos = (Pos) obj;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }
    
    public static int solution(int[][] board) {
        
        n = board.length; //격자 크기
        Robot rb = new Robot(new Pos(0,0),new Pos(0,1),false); //초기 로봇 위치 
        
        Deque<Robot> deque = new ArrayDeque<>();
        deque.add(rb);
        
        // visited = new boolean[n][n][5];
        visited = new HashSet<>();
        visited.add(rb);
        // for(int i = 0; i<5; i++) visited[0][0][i] = true;
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                Robot now = deque.poll();
                // System.out.println("==============================");
                // System.out.printf("%d %d\n",now.st.x,now.st.y);
                // System.out.printf("%d %d\n",now.en.x,now.en.y);
                // System.out.println(cnt);
                
                if((now.st.x == n-1 && now.st.y == n-1) || (now.en.x == n-1 && now.en.y == n-1)) return cnt;
                
                //상하좌우 이동
                for(int k = 0; k<4; k++){
                    int stX = now.st.x + dx[k];
                    int stY = now.st.y + dy[k];
                    Pos posSt = new Pos(stX,stY);
                    
                    int enX = now.en.x + dx[k];
                    int enY = now.en.y + dy[k];
                    Pos posEn = new Pos(enX,enY);
                    
                    if(stX < 0 || stY < 0 || stX >= n || stY >= n || board[stX][stY] == 1) continue;
                    if(enX < 0 || enY < 0 || enX >= n || enY >= n || board[enX][enY] == 1 || visited.contains(new Robot(posSt,posEn,now.dir)) ) continue;
                    
                    deque.add(new Robot(posSt,posEn,now.dir));
                    visited.add(new Robot(posSt,posEn,now.dir));
                    
                }
                
                //90도 회전
                ArrayList<Robot> nxt = playRotate(now, board);
                for(Robot robot : nxt) deque.add(robot);
                
            }
            
            cnt ++;
            
        }
        
        return -1;
        
    }
    
    //회전
    private static ArrayList<Robot> playRotate(Robot now, int[][] board) {
        
        ArrayList<Robot> arr = new ArrayList<>();
        int x = now.st.x;
        int y = now.st.y;
        
        //로봇이 세로 방향일 때
        if(now.dir){
            
            //왼쪽 방향으로 회전
            if(x+1 < n && y-1 >= 0 && board[x][y-1] == 0 && board[x+1][y-1] == 0){
                Robot r1 = new Robot(now.st,new Pos(x,y-1),!now.dir); //st고정
                Robot r2 = new Robot(now.en,new Pos(x+1,y-1),!now.dir); //en고정
                
                if(!visited.contains(r1)){
                    visited.add(r1);
                    arr.add(r1);
                }
                if(!visited.contains(r2)){
                    visited.add(r2);
                    arr.add(r2);
                }
            }
            
            //오른쪽 방향으로 회전
            if(x+1 < n && y+1 < n && board[x][y+1] == 0 && board[x+1][y+1] == 0){
                Robot r1 = new Robot(now.st,new Pos(x,y+1),!now.dir); //st고정
                Robot r2 = new Robot(now.en,new Pos(x+1,y+1),!now.dir); //en고정
                
                if(!visited.contains(r1)){
                    visited.add(r1);
                    arr.add(r1);
                }
                if(!visited.contains(r2)){
                    visited.add(r2);
                    arr.add(r2);
                }
                
            }
          
        }
        else {
            
            //위쪽으로 회전
            if(y+1 < n && x-1>=0 && board[x-1][y] == 0 && board[x-1][y+1] == 0){
                Robot r1 = new Robot(now.st, new Pos(x-1,y),!now.dir);
                Robot r2 = new Robot(now.en, new Pos(x-1,y+1),!now.dir);
                
                if(!visited.contains(r1)){
                    visited.add(r1);
                    arr.add(r1);
                }
                if(!visited.contains(r2)){
                    visited.add(r2);
                    arr.add(r2);
                }
            }
            //아래쪽으로 회전
            if(y+1 < n && x+1 < n && board[x+1][y] == 0 && board[x+1][y+1] == 0){
                Robot r1 = new Robot(now.st, new Pos(x+1,y),!now.dir);
                Robot r2 = new Robot(now.en,new Pos(x+1,y+1),!now.dir);
                
                if(!visited.contains(r1)){
                    visited.add(r1);
                    arr.add(r1);
                }
                if(!visited.contains(r2)){
                    visited.add(r2);
                    arr.add(r2);
                }
                
            }
        }
        
        return arr;
        
    }

}