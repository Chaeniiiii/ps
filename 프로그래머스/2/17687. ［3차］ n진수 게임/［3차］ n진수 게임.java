import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < m * t){
            sb.append(Integer.toString(num++,n).toUpperCase());
        }
        
        StringBuilder result = new StringBuilder();
        p--;
        for(int i = 0; i < t; i++){
            result.append(sb.charAt(p));
            p+=m;
        }
        
        return result.toString();
        
    }
}