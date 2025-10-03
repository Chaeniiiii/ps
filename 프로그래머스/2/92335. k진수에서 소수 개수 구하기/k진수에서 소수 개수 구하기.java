import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        while(n >= k){
            sb.insert(0,n%k);
            n /= k;
        }
        
        sb.insert(0,n);
        
        String[] number = sb.toString().split("0");
        int result = 0;
        
        for(String num : number){
            if("".equals(num) || num == null || num.isEmpty()) continue;
            if(isPrime(Long.parseLong(num))) result++;
            
        }
        
        
        return result;
        
    }
    
    private static boolean isPrime(long num){
     
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}