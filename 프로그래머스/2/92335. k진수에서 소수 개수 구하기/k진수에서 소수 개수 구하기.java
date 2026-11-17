import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String str = Integer.toString(n,k);
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            sb.insert(0,str.charAt(i));
            if(str.charAt(i) == '0' || i == 0){
                if(isPrime(Long.parseLong(sb.toString()))) cnt++;
                sb = new StringBuilder();
            }   
        }
        return cnt;
    }
    
    private boolean isPrime(long num){
        if(num < 2) return false;
        
        for(long i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
        
    }
    
}