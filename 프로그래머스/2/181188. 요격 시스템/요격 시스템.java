import java.util.*;

class Solution {
    public int solution(int[][] targets) {

        Arrays.sort(targets, (a,b) -> a[1]-b[1]);
        
        int end = targets[0][1];
        int cnt = 1;
        
        for(int i = 1; i<targets.length; i++){
            if(targets[i][0] >= end){
                cnt ++;
                end = targets[i][1];
            }
        }
        
        return cnt;
        
    }
}