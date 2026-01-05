import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int len = number.length() - k;
        int st = 0;
        
        for(int i = 0; i < len; i++){
            
            int max = 0;
            for(int j = st; j <= i + k; j++){
                if(number.charAt(j) - '0' > max){
                    max = number.charAt(j) - '0';
                    st = j + 1;
                } 
            }
            
            sb.append(max);
            
        }
        
        return sb.toString();
    }
}