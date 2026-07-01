import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String,Integer> map = new HashMap<>();
        for(String str : wordDict){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                String word = s.substring(j,i);
                if(map.get(word) != null && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
        
    }
}