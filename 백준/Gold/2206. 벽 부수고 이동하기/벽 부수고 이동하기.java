import java.io.*;
import java.util.*;

public class Main {

    public static class Pos {
        int x;
        int y;
        int t;
        int use;

        private Pos(int x, int y, int t, int use){
            this.x = x;
            this.y = y;
            this.t = t;
            this.use = use;
        }
    }

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        String str;
        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = (int)(str.charAt(j)-'0');
            }
        }

        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0,1,0));

        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!deque.isEmpty()){

            Pos now = deque.poll();
            if(now.x == n-1 && now.y == m-1){
                System.out.println(now.t);
                return;
            }

            for(int k = 0; k < 4; k++){

                int mvX = now.x + dx[k];
                int mvY = now.y + dy[k];
                int ifUse = now.use;

                if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || visited[mvX][mvY][ifUse]) continue;
                if(board[mvX][mvY] == 1){
                    if(ifUse == 1) continue;
                    ifUse = 1;
                }

                visited[mvX][mvY][ifUse] = true;
                deque.add(new Pos(mvX,mvY,now.t+1,ifUse));

            }

        }

        System.out.println(-1);

    }
}