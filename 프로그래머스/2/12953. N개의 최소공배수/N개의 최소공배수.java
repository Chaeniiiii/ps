import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        return getLCM(arr);
        
    }
    
    private int getLCM(int[] arr){
        if(arr.length == 1) return arr[0];
        
        int gcd = getGCD(arr[0],arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for(int i = 2; i < arr.length; i++){
            gcd = getGCD(lcm,arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        return lcm;
            
        
    }
    
    private int getGCD(int a, int b){
        
        if(a % b == 0) return b;
        return getGCD(b, a % b);
        
    }
}