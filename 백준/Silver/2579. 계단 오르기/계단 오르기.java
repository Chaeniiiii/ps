import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int[] score = new int[t + 1];
        int[] dp = new int[t + 1];

        for(int i = 1; i <= t; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];
        if(t >= 2){
            dp[2] = score[1] + score[2];
        }
        
        for(int i = 3; i <= t; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + score[i-1]) + score[i];
        }

        System.out.println(dp[t]);

    }
}