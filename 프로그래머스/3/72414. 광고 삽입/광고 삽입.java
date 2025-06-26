import java.util.*;

class Solution {
    
    long[] times; 
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int adTime = toSeconds(adv_time);
        int playTime = toSeconds(play_time);
        times = new long[playTime+1];
        Arrays.fill(times,0);
        
        for(String log : logs){
            String[] splited = log.split("-");
            times[toSeconds(splited[0])]++;
            times[toSeconds(splited[1])]--;
        }

        for(int i = 1; i <= playTime ; i++){
            times[i] += times[i-1];
        }
        
        for(int i = 1; i <= playTime; i++){
            times[i] += times[i-1];
        }
        
        int sTime = 0; 
        long ansTime = times[adTime-1];
        
        for(int i = 1; i <= playTime-adTime;i++){
            if(times[i+adTime-1] - times[i-1] > ansTime){
                ansTime = times[i+adTime-1] - times[i-1];
                sTime = i;
            }
        }
        
        return toFormatted(sTime);
    }
    
    public int toSeconds(String time){
        String[] splited = time.split(":");
        int hours = Integer.parseInt(splited[0]);
        int minutes = Integer.parseInt(splited[1]);
        int seconds = Integer.parseInt(splited[2]);
        
        return hours * 3600 + minutes * 60 + seconds;
    }
    
    public String toFormatted(int time){
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = (time % 3600) % 60;
        
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }
}