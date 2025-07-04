import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int aTime = toSeconds(adv_time);
        int pTime = toSeconds(play_time);
        
        long[] dp = new long[pTime  + 1];
        
        for(String log : logs){
            
            String[] logTime = log.split("-");
            
            dp[toSeconds(logTime[0])]++;
            dp[toSeconds(logTime[1])]--;
            
        }
        
        for(int i = 1; i <= pTime; i++){
            dp[i] += dp[i-1];
        }
        
        for(int i = 1; i <= pTime; i++){
            dp[i] += dp[i-1];
        }
        
        int result = 0;
        long maxTime = dp[aTime - 1];
        
        for(int i = 1; i <= pTime - aTime; i++){
            if(dp[i + aTime -1] - dp[i - 1] > maxTime){
                maxTime = dp[i + aTime -1] - dp[i - 1];
                result = i;
            }
        }
        
        return toTime(result);
        
    }
    
    private static int toSeconds(String time){
        
        String[] timeArr = time.split(":");
        
        int h = Integer.parseInt(timeArr[0]) * 3600;
        int m = Integer.parseInt(timeArr[1]) * 60;
        int s = Integer.parseInt(timeArr[2]);
        
        return h + m + s;
        
    }
    
    private static String toTime(int time){
        
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = (time % 3600) % 60;
        
        return String.format("%02d:%02d:%02d",h,m,s);
        
    }
}