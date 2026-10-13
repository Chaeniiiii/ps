import java.util.*;

class Solution {
    public int solution(int n) {
        
        int result = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = i; j <= n; j++){
                cnt += j;
                if(cnt == n) result++;
                else if(cnt > n) break;
            }
        }
        
        return result;
        
    }
}