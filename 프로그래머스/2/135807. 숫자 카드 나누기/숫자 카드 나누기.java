import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        int answer = 0;
        
        int aGCD = arrayA[0], bGCD = arrayB[0];
        for(int i = 1; i<arrayA.length; i++){
            aGCD = getGCD(aGCD, arrayA[i]);
        }
        
        for(int i = 1; i<arrayB.length; i++){
            bGCD = getGCD(bGCD, arrayB[i]);
        }
        
        if(aGCD > bGCD){
            if(canDivide(arrayB,aGCD)) answer = Math.max(answer,aGCD);
        }
        else if(aGCD < bGCD){
            if(canDivide(arrayA,bGCD)) answer = Math.max(answer,bGCD);
        }
        
        return answer;
        
    }
    
    private static boolean canDivide(int [] arr, int num){
        
        for(int n : arr){
            if(n%num ==0) return false;
        }
        
        return true;
        
    }
    
    private static int getGCD(int num1, int num2){
        
        if(num1 % num2 == 0) return num2;
        return getGCD(num2,num1%num2);
        
    }
}