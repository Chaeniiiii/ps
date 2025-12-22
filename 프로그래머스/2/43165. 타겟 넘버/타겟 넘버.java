import java.util.*;

class Solution {
    
    private static int result;
    
    public int solution(int[] numbers, int target) {
        
        result = 0;
        dfs(numbers, 0,0,target);
        
        return result;
            
    }
    
    private static void dfs(int[] numbers, int idx, int cnt, int target){

        if(idx == numbers.length){
            if(cnt == target) result ++;
            return;
        }

        dfs(numbers, idx+1, cnt+numbers[idx], target);
        dfs(numbers, idx+1, cnt-numbers[idx], target);
        
    }
}