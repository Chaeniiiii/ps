import java.util.*;

class Solution {
    
    private static class Traffic {
        int start;
        int end;
        
        private Traffic(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        
        ArrayList<Traffic> arr = new ArrayList<>();
        
        for(int i = 0; i < lines.length; i++) {
            String[] line = lines[i].replace("2016-09-15 ", "").split(" ");
            String[] endTime = line[0].split(":");
            
            // 끝나는 시간을 밀리초로 변환
            int end = getTime(endTime);
            
            // 처리 시간을 밀리초로 변환
            int duration = (int)(Double.parseDouble(line[1].replace("s", "")) * 1000);
            
            // 시작 시간 = 끝 시간 - 처리 시간 + 1
            int start = end - duration + 1;
            
            arr.add(new Traffic(start, end));
        }
        
        int result = 1;
        
        for(Traffic trf : arr) {
            // 각 로그의 시작 시점에서 1초 구간 검사
            int startCnt = getMaxCount(arr, trf.start);
            // 각 로그의 끝 시점에서 1초 구간 검사  
            int endCnt = getMaxCount(arr, trf.end);
            
            result = Math.max(result, Math.max(startCnt, endCnt));
        }
        
        return result;
    }
    
    private int getMaxCount(ArrayList<Traffic> arr, int startTime) {
        
        int cnt = 0;
        
        for(Traffic trf : arr) {
            if(trf.start < startTime + 1000 && trf.end >= startTime) {
                 cnt++;
            }
        }
        
        return cnt;
    }
    
    private static int getTime(String[] time) {
        
        int h = Integer.parseInt(time[0]) * 3600 * 1000;
        int m = Integer.parseInt(time[1]) * 60 * 1000;
        int ms = (int)(Double.parseDouble(time[2]) * 1000);
        
        return h + m + ms;
        
    }
}