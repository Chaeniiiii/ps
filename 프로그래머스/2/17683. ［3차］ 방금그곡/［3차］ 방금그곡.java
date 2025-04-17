import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        int maxPlayTime = 0;
        String answer = "(None)";
        
        for (String music : musicinfos) {
            
            String[] info = music.split(",");
            int total = getTime(info[0], info[1]); // 재생 시간 계산
           
            String sheet = getSheet(info[3]);
            String neoSheet = getSheet(m);
            
            String totalSheet = "";
            for(int i = 0; i<total; i++){
                totalSheet+=(sheet.charAt(i%sheet.length()));
            }
            
            if(totalSheet.contains(neoSheet)){
                if(maxPlayTime >= total) continue;
                maxPlayTime = total;
                answer = info[2];
            }
            
        }
        
        return answer;
    }
    
    private static String getSheet(String sh){
        
        sh = sh.replace("A#","a").replace("B#","b").replace("C#","c")
            .replace("D#","d").replace("F#","f").replace("G#","g");
        
        return sh;
        
    }
    
    private static int getTime(String start, String end) {
        String[] sTime = start.split(":");
        String[] eTime = end.split(":");
        
        int startTime = Integer.parseInt(sTime[0]) * 60 + Integer.parseInt(sTime[1]);
        int endTime = Integer.parseInt(eTime[0]) * 60 + Integer.parseInt(eTime[1]);
        
        return endTime - startTime;
    }
}
