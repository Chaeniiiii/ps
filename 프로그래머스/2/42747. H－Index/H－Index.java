import java.util.*;

class Solution {
    
    private static int[] c;
    
    public int solution(int[] citations) {
        
        c = citations;
        Arrays.sort(citations);
        
        int lt = 0, rt = c[c.length - 1];
        int result = 0;
        
        while(lt <= rt){
            
            int mid = (lt + rt)/2;
            
            if(isPossible(mid)){
                lt = mid + 1;
                result = Math.max(result,mid);
            }
            else{
                rt = mid - 1; 
            }
        }
        
        return result;
        
    }
    
    private static boolean isPossible(int hIndex){
        
        int cnt = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] >= hIndex) cnt++;
        }
        
        return cnt >= hIndex ? true : false;
        
    }
}