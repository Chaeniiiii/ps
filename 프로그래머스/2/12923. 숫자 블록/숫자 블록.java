import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        int len = (int)(end - begin);
        int[] result = new int[len+1];
        Arrays.fill(result,1);
        result[0] = 0;
        
        boolean[] visited = new boolean[len+1];
        
        int idx = len;
        for(long st = end; st >= begin; st--){
            if(visited[idx]) idx--;
            if(idx == 0) break;
            
            int gcd = getGcd(end, st);
            result[idx] = gcd;
            
            int newIdx = idx;
            
            while(newIdx > st){
                result[newIdx] = gcd;
                visited[newIdx] = true;
                newIdx -= gcd;
            }
            
            idx--;
            
        }
        
        return result;
        
    }
    
    private static int getGcd(long end, long num){
        
        for(int i = (int)num - 1 ; i >= 2; i--){
            if(num % i == 0) return i;
        }
        
        return 1;
        
    }
    
}