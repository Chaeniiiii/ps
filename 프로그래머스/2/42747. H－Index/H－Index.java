import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int len = citations.length;
        Arrays.sort(citations);
        
        int cnt = 0;
        int result = 0;
        
        for(int i = 0; i<len; i++){
            while(cnt <= citations[i]){
                if(cnt <= (len-i) ) result = Math.max(result,cnt);    
                cnt++;
            }
            
        }
        
        return result;
        
    }
}