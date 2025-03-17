import java.util.*;

class Solution {
    
    private static int len, cnt;
    
    public int solution(int[] numbers, int target) {
        
        cnt = 0;
        len = numbers.length;
        
        dfs(0,numbers[0],target,numbers);
        dfs(0,-numbers[0],target,numbers);
        
        return cnt;
        
    }
    
    private static void dfs(int dep, int num, int target, int [] numbers){
        
        if(dep == len-1 && num == target){
            cnt ++;
            return;
        }
        
        if(dep >= len-1) return;
        
        dfs(dep+1,num+numbers[dep+1],target,numbers);
        dfs(dep+1,num-numbers[dep+1],target,numbers);
        
    }
}