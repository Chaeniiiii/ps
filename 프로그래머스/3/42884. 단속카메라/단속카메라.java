import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int cnt = 0;
        int camera = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < routes.length; i++){
            
            if(camera < routes[i][0]){
                camera = routes[i][1];
                cnt++;
            }
        }
        
        return cnt;
        
    }
}