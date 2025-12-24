import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String str = getNum(n,k);

        StringBuilder sb = new StringBuilder();
        int cnt = 0, idx = str.length() - 1;
        
        while(idx >= 0){
            char c = str.charAt(idx);
            if(c == '0'){
                if(isPrime(sb.reverse().toString())) cnt++;
                sb = new StringBuilder();
            }
            else{
                sb.append(c);
            }
            idx--;
        }
        
        if(sb.length() > 0 && isPrime(sb.reverse().toString())) return cnt + 1;
        return cnt;
        
    }
    
    private static boolean isPrime(String str){
        
        if(str.length() == 0) return false;
        
        long num = Long.parseLong(str);
        if(num < 2) return false;
        
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
        
    }
    
    private static String getNum(int n, int k){
        
        if(n < k) return String.valueOf(n);
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            
            sb.append(n % k);
            n /= k;
            
        }
        
        return sb.reverse().toString();
        
    }
    
}