import java.util.*;

class Solution {
    
    private static int len, cnt;
    private static int[] numArr;
    
    public int solution(int[] numbers, int target) {
        
        cnt = 0;
        len = numbers.length;
        numArr = numbers;
        
        dfs(0,numArr[0],target);
        dfs(0,-numArr[0],target);
        
        return cnt;
        
    }
    
    private static void dfs(int dep, int num, int target){
        
        if(dep == len-1 && num == target){
            cnt ++;
            return;
        }
        
        if(dep >= len-1) return;
        
        dfs(dep+1,num+numArr[dep+1],target);
        dfs(dep+1,num-numArr[dep+1],target);
        
    }
}