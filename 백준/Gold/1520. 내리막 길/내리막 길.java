import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[][] board, dp;

    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        dfs(0,0);

        System.out.println(dp[0][0]);

    }

    private static int dfs(int x, int y){

        if(x == n - 1 && y == m - 1){
            return 1;
        }

        if(dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;

        for(int k = 0; k < 4; k++){

            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] >= board[x][y]) continue;
            dp[x][y] += dfs(nx,ny);

        }

        return dp[x][y];

    }

}
