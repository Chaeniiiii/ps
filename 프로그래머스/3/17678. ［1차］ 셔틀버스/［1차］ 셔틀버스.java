import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        int len = timetable.length;
        
        //승객 오름차순 정렬
        int[] tt = new int[len];
        for(int i = 0; i < len; i++){
            tt[i] = convertI(timetable[i]);
        }
        
        Arrays.sort(tt);
        
        //버스 운행 시간
        int st = 540;
        int[] bus = new int[n];
        for(int i = 0; i < n; i++){
            bus[i] = st;
            st += t;
        }
        
        //탈 수 있는 승객 수
        int[] possibleTime = new int[n];
        //마지막에 태운 승객 정보 
        int[] psgInfo = new int[n];
            
        //마지막에 태운 승객 
        int idx = 0;
        for(int i = 0; i < n; i++){
            
            int cnt = 0; //현재 태운 승객 수
            int nowBus = bus[i]; //현재 버스 도착 시간 
            while(idx < len && nowBus >= tt[idx]){
                cnt++;
                idx++;
                if(cnt == m) break;
            }
            
            psgInfo[i] = (idx == 0 && tt[idx] > nowBus) ? nowBus : tt[idx - 1];
            possibleTime[i] = cnt;
            
        }
        
        int busIdx = n - 1;
        if(possibleTime[busIdx] == m) return convertS(psgInfo[busIdx] - 1);
        else return convertS(Math.max(psgInfo[busIdx],bus[busIdx]));
        
    }
    
    //시간 변환(String to int)
    private int convertI(String time){
        
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);
        
        return h + m;
    }
    
    //시간 변환(int to String)
    private String convertS(int time){
        String h = String.valueOf(time / 60) ;
        if(h.length() == 1) h = "0" + h; 
        String m = String.valueOf(time % 60);
        if(m.length() == 1) m = "0" + m;
        return h + ":" + m;
        
    }
    
}