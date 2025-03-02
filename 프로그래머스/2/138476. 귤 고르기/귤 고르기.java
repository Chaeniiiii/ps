import java.util.*;

class Solution {
    
    private static final int SIZE = 10000000;
    
    public int solution(int k, int[] tangerine) {
        
        int [] arr = new int[SIZE+1];
        for(int i : tangerine) arr[i]++;
        
        Arrays.sort(arr);
        
        int cnt = 0;
        
        for(int i = SIZE; i>=0; i--){
            k-=arr[i];
            cnt ++;
            if(k <=0) break;
        }        
        
        return cnt;
        
    }
}