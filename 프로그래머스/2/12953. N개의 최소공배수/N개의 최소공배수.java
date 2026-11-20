import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        int gcd = getGcd(arr[0],arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for(int i = 2; i < arr.length; i++){
            gcd = getGcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        return lcm;
        
    }
    
    private int getGcd(int a, int b){
        if(a % b == 0) return b;
        return getGcd(b, a % b);
    }
}