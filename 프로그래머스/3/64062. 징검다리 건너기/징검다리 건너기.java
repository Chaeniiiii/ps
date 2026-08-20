import java.util.*;

class Solution {

    private int k;
    private int[] stones;
    
    public int solution(int[] stones, int k) {
        
        this.k = k;
        this.stones = stones;
        
        int lt = 1 , rt = 200_000_000 * 2;
        int result = 0;
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            
            if(isPossible(mid)){
                result = Math.max(mid,result);
                lt = mid + 1;
            }
            else{
                rt = mid - 1;
            }
        }
        
        return result;
        
    }
    
    private boolean isPossible(int cnt){
        
        int skip = 0;
        
        for(int i = 0; i < stones.length; i++){
            if(stones[i] - cnt < 0){
                skip++;
            }
            else{
                skip = 0;
            }
            
            if(skip == k) return false;
        }
        
        return true;
        
        
    }
}