import java.util.*;

class Solution {
    
    private static final int MAX = 360000;
    
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int[] time = new int[MAX+1];
        
        for(String log : logs){
            String[] info = log.split("-");
            int start = ToInt(info[0]);
            int end = ToInt(info[1]);
            
            time[start]++;
            time[end]--;
        }
        
        int end = ToInt(play_time);
        int adv = ToInt(adv_time);
        int max_start = end - adv;
        
        for(int i = 1; i < time.length; i++){
            time[i]+=time[i-1];
        }
        
        long max = 0;
        long now = max;
        int start = 0;
        
        for(int i = adv; i <= end; i++){
            
            now += time[i] - time[i-adv];
            
            if(now > max){
                start = i - adv + 1;
                max = now;
            }
        }
        
        return ToTime(start);
        
    }
    
    public int ToInt(String time){
        
        String[] t = time.split(":");
        
        return Integer.parseInt(t[2])+
            Integer.parseInt(t[1])*60+
            Integer.parseInt(t[0])*60*60;
    }
    
    public String ToTime(int time){
        
        int hour= time/3600;
        String sh=String.valueOf(hour);
        if(hour<10) sh="0"+sh;
                
        time-=hour*3600;
        
        int min= time/60;
        time-=min*60;
        String mh=String.valueOf(min);
        
        if(min<10) mh="0"+mh;
        
        String ch=String.valueOf(time);
        if(time<10) ch="0"+ch;
        
        return sh+":"+mh+":"+ch;
        
    }
}