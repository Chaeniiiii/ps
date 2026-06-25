import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
       
        int[] arr = new int[10001];
        int[] dp = new int[10001];

        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i];
        } 

        dp[0] = arr[0];
        dp[1] = arr[1];

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + arr[i]);
        }

        return dp[dp.length - 1];


    }
}