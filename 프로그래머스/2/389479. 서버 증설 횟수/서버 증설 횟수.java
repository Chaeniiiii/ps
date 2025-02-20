class Solution {
    
    private static final int SIZE = 24;
    
    public int solution(int[] players, int m, int k) {
        
        int [] server = new int[SIZE];
        int cnt = 0;
        
        for(int i = 0; i<SIZE; i++){
            
            if(players[i] >= m){
                
                int plyr = (players[i]-(m*server[i])) / m;
                
                if(plyr <= 0) continue;
                
                cnt += plyr;
                for(int j = i; j<(i+k >= SIZE ? SIZE : i+k); j++) {
                    server[j] +=plyr;
                }
                
            }
        }
        
        return cnt;
        
    }
}