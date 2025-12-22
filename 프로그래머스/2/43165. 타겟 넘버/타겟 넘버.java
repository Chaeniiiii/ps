import java.util.*;

class Solution {
    
    public int solution(int[] numbers, int target) {
        
        return dfs(numbers, 0,0,target);
            
    }
    
    private static int dfs(int[] numbers, int idx, int cnt, int target){
        
        int result = 0;
        
        if(idx == numbers.length) return result;
        if(cnt == target) result ++;
        
        result += dfs(numbers, idx+1, cnt+numbers[idx], target);
        result += dfs(numbers, idx+1, cnt-numbers[idx], target);
        
        return result;
        
    }
}