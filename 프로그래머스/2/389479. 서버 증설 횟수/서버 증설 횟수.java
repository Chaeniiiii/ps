import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int cnt = 0 , server = 0;
        int[] addServer = new int[players.length];
        
        for(int i = 0; i < players.length; i++){
            
            int div = players[i] / m;
            
            if(i >= k){
                server -= addServer[i-k];
            }
            
            if(div > server){
                int diff = div - server;
                cnt += diff;
                server += diff;
                addServer[i] = diff;
            }            
            
        }
        
        return cnt;
        
    }
}