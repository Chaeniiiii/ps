import java.util.*;

class Solution {
    public int solution(int n) {
        
        int cnt = Integer.bitCount(n);
        int other = 0;
        
        while(cnt != other){
            ++n;
            other = Integer.bitCount(n);
        }
        
        return n;
        
    }
}