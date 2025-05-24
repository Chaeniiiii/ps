import java.util.*;

class Solution {
    
    private static final int MAX = 200000000;
        
    public int solution(int[] stones, int k) {
        
        int lt = 1, rt = MAX;
        int result = 0;
        
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            
            if(canCross(stones,k,mid)) {
                lt = mid + 1;
                result = Math.max(mid,result);
            }
            else rt = mid - 1;
            
        }
        
        return result;
        
    }
    
    private static boolean canCross(int [] stones, int k, int niniz){
        
        int impossible = 0;
        
        for(int stone : stones){
            
            if(stone - niniz < 0) impossible ++;
            else impossible = 0;
            
            if(impossible == k) return false;
            
        }
        
        return true;
        
        
    }
    
}