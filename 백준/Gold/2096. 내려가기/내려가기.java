import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][3];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][3];
        dp[0] = board[0].clone();

        //최대 점수 구하기 
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1]) + board[i][j];
                }
                if(j == 1){
                    dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i-1][j-1], dp[i-1][j+1])) + board[i][j];
                }
                if(j == 2){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + board[i][j]; 
                }
            }
        }

        int rMax = Math.max(Math.max(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);

        dp = new int[n][3];
        dp[0] = board[0].clone();
        //최소 점수 구하기 
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + board[i][j];
                }
                if(j == 1){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i-1][j+1])) + board[i][j];
                }
                if(j == 2){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + board[i][j]; 
                }
            }
        }

        int rMin = Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
        System.out.printf("%d %d",rMax,rMin);


    }

}