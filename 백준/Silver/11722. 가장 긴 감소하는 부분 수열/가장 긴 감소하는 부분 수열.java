import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(number[i] < number[j]){
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
