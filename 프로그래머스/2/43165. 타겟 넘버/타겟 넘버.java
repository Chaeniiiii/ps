import java.util.*;

class Solution {
    
    private int result, target;
        
    public int solution(int[] numbers, int target) {
        
        result = 0;
        this.target = target;
        
        dfs(0, numbers,0);
        return result;
        
    }
    
    private void dfs(int dep, int[] numbers, int cnt){
        
        if(dep == numbers.length){
            if(cnt == target) result++;
            return ;
        }
        
        dfs(dep+1, numbers, cnt + numbers[dep]);
        dfs(dep+1, numbers, cnt - numbers[dep]);
        
    }
    
}