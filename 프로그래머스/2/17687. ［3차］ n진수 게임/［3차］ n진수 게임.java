import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(1);
        
        int num = 2;
        while(sb.length() < t * m){
            sb.append(getNum(num,n));
            num++;
        }
        
        int st = p - 1;
        StringBuilder result = new StringBuilder();
        
        while(result.length() < t){
            result.append(sb.charAt(st));
            st+=m;
        }
        
        return result.toString();
        
    }
    
    private static String getNum(int num, int n){
        
        StringBuilder sb = new StringBuilder();
        int div;
        while(num > 0){
            div = num % n;
            num /= n;
            
            if(div >= 10) sb.append((char)('A' + (div - 10)));
            else sb.append(div);
        }
        
        return sb.reverse().toString();
        
    }
    
}