import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        Arrays.sort(arrayA);   
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB); 
        
        if(gcdA <= 1 && gcdB <= 1 && gcdA == gcdB) return 0;
        if(gcdA > gcdB && divCard(arrayB, gcdA)) return gcdA;
        if(gcdA < gcdB && divCard(arrayA, gcdB)) return gcdB;
        
        return 0;
        
    }
    
    private static int getGcd(int[] arr){
        
        if(arr.length == 1) return arr[0];
        
        int gcd = calcGcd(arr[0],arr[1]);
        for(int i = 2; i < arr.length - 1; i++){
            gcd = calcGcd(gcd,arr[i]);
        }
        
        return gcd;
        
    }
    
    private static int calcGcd(int a, int b){
        if(b == 0) return a;
        return calcGcd(b,a%b);
    }
    
    private static boolean divCard(int[] arr, int gcd){
        
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] % gcd == 0)  return false;
        }
        
        return true;
        
    }
    
}