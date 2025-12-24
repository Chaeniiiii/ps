import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder convertN = new StringBuilder();
        convertN.append(0);
        int num = 1;
        
        while(convertN.length() <= t * m){
            
            String str = getNum(num,n);
            for(char c : str.toCharArray()){
                convertN.append(c);
            }
                
            num++;
            
        }
        
        String conv = convertN.toString();
        StringBuilder result = new StringBuilder();
        
        int st = p-1;
        while(result.length() < t){
            result.append(conv.charAt(st));
            st+=m;
        }
        
        return result.toString();
        
    }
    
    private static String getNum(int n, int k){
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int div = n % k;
            n /= k;
            if(div > 9) sb.append((char)('A' + (div - 10)));
            else sb.append(div);
        }
        
        return sb.reverse().toString();
        
    }
    
}