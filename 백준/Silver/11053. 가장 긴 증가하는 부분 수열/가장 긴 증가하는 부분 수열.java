import java.util.*;
import java.io.*;

public class Main {

    private static int[] dp, number;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        for(int i = 0; i < n; i++){ 
            dp[i] = 1;
            for(int j = 0; j < n; j++){
                if(number[j] < number[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int result = 1;
        for(int i = 0; i < n; i++){
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);

    }

}
