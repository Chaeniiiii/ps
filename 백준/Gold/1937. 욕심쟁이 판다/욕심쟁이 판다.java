import java.util.*;
import java.io.*;

public class Main {

    private static int n, result;
    private static int[][] board, dp;

    private static int[] dx = new int[]{-1,0,1,0};
    private static int[] dy = new int[]{0,-1,0,1};
    
    public static void main(String[] args) throws Exception{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];

        result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] != 0) continue;
                result = Math.max(dfs(i,j), result);
            }
        }

        System.out.println(result);

    }

    private static int dfs(int x, int y){

        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] <= board[x][y]) continue;
            dp[x][y] = Math.max(dp[x][y],dfs(nx,ny) + 1);
            
        }

        return dp[x][y];

    }

}
