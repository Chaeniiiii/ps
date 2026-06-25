import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
       
        int[] arr = new int[10001];

        int max = 0;
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i];
            max = Math.max(max,nums[i]);
        } 

        int[] dp = new int[max+1];
        dp[0] = arr[0];
        dp[1] = arr[1];

        for(int i = 2; i <= max; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + arr[i]);
        }

        return dp[max];


    }
}