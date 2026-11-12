import java.util.*;

class Solution {
    
    private int[] citations;
    
    public int solution(int[] citations) {
        
        this.citations = citations;
        int lt = 0 , rt = citations.length, result = 0;
        
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            
            if(isPossible(mid)){
                result = mid;
                lt = mid + 1;
            }
            else{
                rt = mid - 1;
            }
            
        }
        
        return result;
        
    }
    
    private boolean isPossible(int h){
        
        int cnt = 0;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= h) cnt++;
        }
        
        return cnt >= h;
        
    }
    
}