import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int end = Integer.MIN_VALUE;
        int cnt = 0;
        
        for(int i = 0; i < routes.length; i++){
            if(routes[i][0] > end){
                cnt++;
                end = routes[i][1];
            }
        }
        
        return cnt;
        
    }
}