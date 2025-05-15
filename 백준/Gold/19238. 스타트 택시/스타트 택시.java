import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = Integer.MAX_VALUE;
    private static int n,m,fuel;

    private static final int [] dx = new int[]{-1,1,0,0};
    private static final int [] dy = new int[]{0,0,-1,1};

    private static class Psg {

        Pos str;
        Pos en;
        int dist;

        private Psg (Pos str, Pos en, int dist) {
            this.str = str;
            this.en = en;
            this.dist = dist;
        }
    }

    private static class Pos {
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        //격자 채우기
        int [][] board = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //택시 출발 위치
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Pos start = new Pos(x, y);

        //승객 위치 및 초기 택시와의 거리 계산
        ArrayList<Psg> passenger = new ArrayList<>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int stX = Integer.parseInt(st.nextToken());
            int stY = Integer.parseInt(st.nextToken());
            int enX = Integer.parseInt(st.nextToken());
            int enY = Integer.parseInt(st.nextToken());

            Psg psg = new Psg(new Pos(stX, stY),new Pos(enX, enY), MAX);
            passenger.add(psg);
        }

        Psg minDist = new Psg(new Pos(0,0), new Pos(0,0), MAX);
        
        //손님 태우기
        while(m-- > 0){
            for(Psg psg : passenger){
                psg.dist = bfs(start, psg.str ,board,false , true);
                if(psg.dist < minDist.dist) minDist = psg;
                else if(psg.dist == minDist.dist){
                    if(psg.str.x == minDist.str.x){
                        if(psg.str.y < minDist.str.y) minDist = psg;
                    }
                    else {
                        if(psg.str.x < minDist.str.x) minDist = psg;
                    }
                }
            }

            if(bfs(start, minDist.str , board, false, false) == 1){
                if(bfs(minDist.str, minDist.en, board, true, false) == 1) {
                    passenger.remove(minDist);
                    start = minDist.en;
                    minDist = new Psg(new Pos(0,0), new Pos(0,0), Integer.MAX_VALUE);
                    continue;
                }
            }

            System.out.println(-1);
            return;

        }

        System.out.println(fuel);

    }

    private static int bfs(Pos st, Pos en, int [][] board, boolean dest, boolean calc){

        // System.out.printf("%d %d\n",st.x,st.y);
        // System.out.printf("%d %d\n",en.x,en.y);

        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(st);

        boolean [][] visited = new boolean[n+1][n+1];
        visited[st.x][st.y] = true;

        int cnt = 0;

        while(!deque.isEmpty()){

            int size = deque.size();

            for(int i = 0; i<size; i++){

                Pos mv = deque.poll();
                if(mv.x == en.x && mv.y == en.y){
                    if(calc) return cnt;
                    else {
                        if(cnt > fuel) return MAX;
                        fuel-=cnt;
                        if(dest) fuel += cnt*2;
                        return 1;
                    }
                    
                }
                if(cnt > fuel) return MAX;

                for(int k = 0; k<4; k ++){
                    
                    int mvX = mv.x + dx[k];
                    int mvY = mv.y + dy[k];

                    if(mvX <= 0 || mvY <= 0 || mvX > n || mvY > n || visited[mvX][mvY] || board[mvX][mvY] == 1) continue;
                    deque.add(new Pos(mvX,mvY));
                    visited[mvX][mvY] = true;

                }

            }

            cnt ++;


        }

        return MAX;
        
    }

    // private static int setDist(Pos st, Pos en, int [][] board){
        
    //     Deque<Pos> deque = new ArrayDeque<>();
    //     deque.add(st);

    //     boolean [][] visited = new boolean[n+1][n+1];
    //     visited[st.x][st.y] = true;

    //     int dist = 0;
    //     while(!deque.isEmpty()){

    //         int size = deque.size();

    //         for(int i = 0; i<size; i++){

    //             Pos mv = deque.poll();
    //             if(mv.x == en.x && mv.y == en.y) return dist;
                
    //             for(int k = 0;k <4; k++){
    //                 int mvX = mv.x + dx[k];
    //                 int mvY = mv.y + dy[k];

    //                 if(mvX <= 0 || mvY <= 0 || mvX > n || mvY > n || visited[mvX][mvY] || board[mvX][mvY] == 1) continue;
    //                 deque.add(new Pos(mvX,mvY));
    //                 visited[mvX][mvY] = true;
    //             }

    //         }

    //         dist ++;

    //     }

    //     return Integer.MAX_VALUE;

    // }

    // private static ArrayList<Psg> sortArr(ArrayList<Psg> passenger){

    //     /**
    //      * 택시 - 승객 거리 순으로 정렬
    //      * 거리가 같다면 행 번호가 작은 승객을 먼저 태우기
    //      * 행 번호도 같다면 열 번호가 작은 승객을 먼저 태우기
    //      */
    //     passenger.sort((a,b) -> {
    //         if(a.dist == b.dist){
    //             if(a.str.x == b.str.x) return a.str.y - b.str.y; //열 번호 오름차순 정렬
    //             return a.str.x - b.str.x; //행 번호 오름차순 정렬
    //         } 
    //         return a.dist - b.dist; //거리순 오름차순 정렬
    //     });

    //     return passenger;

    // }


}