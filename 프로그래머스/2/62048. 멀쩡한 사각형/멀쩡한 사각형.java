import java.util.*;

class Solution {
    public long solution(int w, int h) {
        
        long answer = 0;
        long x = (long)w;
        long y = (long)h;
        
        long gcd = getGcd(x,y);
        
        return x * y - (x+y-gcd);
        
    }
    
    private static long getGcd(long a, long b){
        if(b == 0) return a;
        return getGcd(b,a%b);        
    }
    
}
