import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int a = calc(arrayA);
        int b = calc(arrayB);
        
        if(a == b || (a <= 1 && b <= 1)) return 0;
        
        int result = 0;
        if(div(arrayB,a)) result = Math.max(result,a);
        if(div(arrayA,b)) result = Math.max(result,b);
        return result;
        
    }
    
    private boolean div(int[] arr, int gcd){
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % gcd == 0) return false;
        }
        
        return true;
        
    }
    
    private int calc(int[] arr){
        
        if(arr.length == 1) return arr[0] ;
        
        int gcd = getGcd(arr[0],arr[1]);
        for(int i = 2; i < arr.length; i++){
            gcd = getGcd(gcd,arr[i]);
        }
        return gcd;
    }
    
    private int getGcd(int a, int b){
        if(b == 0) return a;
        return getGcd(b,a%b);
    }
}