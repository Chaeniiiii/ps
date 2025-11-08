import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int[] time = new int[24];
        int cnt = 0;
        
        for(int i = 0; i < players.length; i++){
            
            int play = players[i];
            if(play >= m && time[i] < play/m){
                play -= time[i] *m;
                for(int j = i; j < Math.min(i+k,players.length); j++){
                    time[j]+=play/m;
                }
                cnt+=play/m;
            }
        
        }
        
        return cnt;
        
    }
}