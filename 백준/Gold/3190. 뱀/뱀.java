import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static int [][] board;

    private static int [] dx = {-1,0,1,0};
    private static int [] dy = {0,1,0,-1};

    private static Deque<Move> move;
    
    private static class Pos {
        
        int x;
        int y;

        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }

    private static class Move {
        int t; //게임 시작 시간으로부터 x초가 끝난 뒤 
        int c; //c 방향으로 90도 회전 (L : 왼쪽(0) , D : 오른쪽(1))

        private Move (int t, int c){
            this.t = t ;
            this.c = c ;
        }
    }

    public static void main(String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //보드 크기 
        int k = Integer.parseInt(br.readLine()); //사과 개수 

        board = new int[n+1][n+1] ;
        
        //사과 위치
        for(int i = 0 ; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
        }

        int l = Integer.parseInt(br.readLine()); //뱀의 방향 변환 횟수
        move = new ArrayDeque<>();

        //뱀의 방향 변환 정보
        for(int i = 0; i<l; i++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0) == 'L' ? 0 : 1;

            Move mv = new Move(t,d);
            move.add(mv);
        }

        move(new Pos(1,1));
    }

    private static void move(Pos pos){

        Deque<Pos> deque = new ArrayDeque<>();
        boolean [][] visited = new boolean[n+1][n+1];
        
        Move mv = move.poll();

        deque.add(pos);
        visited[pos.x][pos.y] = true;

        int cnt = 0;

        int dir = 1;
        int idx = 1;

        while(!deque.isEmpty()){
            
            cnt ++;

            Pos now = deque.peek();
            Pos nxt = new Pos(now.x+dx[idx],now.y+dy[idx]);
            
            if(nxt.x <= 0 || nxt.y <= 0 || nxt.x > n || nxt.y > n || visited[nxt.x][nxt.y]) break;

            deque.addFirst(nxt);
            visited[nxt.x][nxt.y] = true;

            if(board[nxt.x][nxt.y] != 1) {
                Pos rmv = deque.pollLast();
                visited[rmv.x][rmv.y] = false;
            }
            else board[nxt.x][nxt.y] = 0;

            if(cnt == mv.t) {
                dir = mv.c;

                if(dir == 0) idx = (idx+3)%4;
                else idx = (idx+1)%4;

                if(!move.isEmpty()) mv = move.poll();
            }

            // System.out.println("===============");
            // for(Pos ps : deque){
            //     System.out.printf("%d %d : %d 초\n",ps.x,ps.y,cnt);
            // }

        }

        System.out.println(cnt);

    }

}