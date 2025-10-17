import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while(t-- > 0){

            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            if(n == 1){
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
            }
            else{

                int dp[][] = new int[2][n]; 

                dp[0][0] = sticker[0][0];
                dp[1][0] = sticker[1][0];

                dp[0][1] = dp[1][0] + sticker[0][1];
                dp[1][1] = dp[0][0] + sticker[1][1] ;

                for(int i = 2; i < n; i++){
                    dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + sticker[0][i];
                    dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + sticker[1][i];
                }
                System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
            }
        }
    }
}