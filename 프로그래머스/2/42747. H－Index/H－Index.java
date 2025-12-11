import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int len = citations.length;
        Arrays.sort(citations);
        
        int hIdx = len;
        
        while(hIdx >= 0){
            
            for(int i = 0; i<len; i++){
                if(citations[i] >= hIdx){
                    if(i <= hIdx && (len-i) >= hIdx) return hIdx;
                    break;
                }
            }
            
            hIdx --;
             
            
        }
        
        return hIdx;
        
    }
}