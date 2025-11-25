import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String tN = transNum(n,k);
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = tN.length()-1; i >= 0; i--){
            
            char c = tN.charAt(i);
            
            if(c == '0'){
                if(sb.length() > 0 && isPrime(sb.toString())) cnt++;
                sb = new StringBuilder();
            } 
            else{
                sb.insert(0,c);    
            }
            
        }
        
        return cnt;
        
    }
    
    private static boolean isPrime(String str){
        
        long num = Long.parseLong(str);
        
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
        
    }
    
    private static String transNum(int n, int k){
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.insert(0,n%k);
            n/=k;
        }
        
        sb.insert(0,n);
        return sb.toString();
        
    }
    
}