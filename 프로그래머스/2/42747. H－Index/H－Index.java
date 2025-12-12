import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int n = citations.length;
        int hIdx;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < n; i++){
            hIdx = n - i;
            if(hIdx <= citations[i]) return hIdx;
        }
        
        return 0;
        
    }
}