import java.util.*;

class Solution {
    
    private int[] stones;
    private int k;
    
    public int solution(int[] stones, int k) {

        this.k = k;
        this.stones = stones;
        int result = 0;
        int lt = 1, rt = 200_000_000;
        
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            
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
    
    private boolean isPossible(int p){
        
        int pass = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < p) pass++;
            else pass = 0;
            if(pass == k) return false;
        }
        
        return true;
        
    }
    
}