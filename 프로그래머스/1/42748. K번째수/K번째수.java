import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int [] result = new int[commands.length];
        
        for(int t = 0; t<commands.length; t++){
            
            int[] cmd = commands[t];
            
            int i = cmd[0];
            int j = cmd[1];
            int k = cmd[2];
            
            int [] arr = new int[j-i+1];
            
            for(int idx = 0; idx<j-i+1; idx++){
                arr[idx] = array[idx+i-1];
            }
            
            Arrays.sort(arr);
            result[t] = arr[k-1];
            
        }
        
        return result;
        
    }
}