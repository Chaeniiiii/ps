import java.util.*;

class Solution {
    
    private static int len;
    
    public int solution(int[] numbers, int target) {
        
        len = numbers.length;
        int total = dfs(numbers,target,0,0,0);
        
        return total;
    }
    
    private static int dfs(int[] numbers, int target, int st, int cnt, int dep){
        
        if(dep == len){
            if(cnt == target) return 1;
            return 0;
        }
        
        for(int i = st; i<len; i++){
            return dfs(numbers,target,i+1,cnt+numbers[i],dep+1) + dfs(numbers,target,i+1,cnt-numbers[i],dep+1);
        }
        
        return 0;
        
    }
}