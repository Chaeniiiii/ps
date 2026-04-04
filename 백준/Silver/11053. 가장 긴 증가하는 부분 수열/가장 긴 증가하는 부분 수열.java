import java.util.*;
import java.io.*;

public class Main {

    private static int[] dp;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        for(int i = 0; i < n; i++){ 
            lis(i,number);
        }

        int result = 1;
        for(int i = 0; i < n; i++){
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);

    }

    private static int lis(int n, int[] number){

        if(dp[n] != 0) return dp[n];
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--){
            if(number[i] < number[n]){
                dp[n] = Math.max(dp[n], lis(i,number) + 1);
            }
        }

        return dp[n];

    }
}
