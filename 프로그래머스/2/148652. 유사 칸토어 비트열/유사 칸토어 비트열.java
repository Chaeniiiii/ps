import java.util.*;

class Solution {
    public int solution(int n, long l, long r) {
        
        int result = 0;
        
        for(long i = l - 1; i < r; i++){
            
            result += findNum(i);
            
        }
        
        return result;
        
    }
    
    private static int findNum(long i){
        
        if(i % 5 == 2) return 0;
        if(i == 0) return 1;
        
        return findNum(i / 5);
        
    }
    
}