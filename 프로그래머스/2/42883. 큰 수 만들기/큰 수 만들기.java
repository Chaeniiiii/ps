import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int len = number.length();
        int start = 0;
        
        int answerLen = len-k;
        
        while(answerLen > 0){
            
            char max = '0';
            int maxIdx = start;
            
            for(int i = start; i<=start+k; i++){
                if(max < number.charAt(i)){
                    maxIdx = i;
                    max = number.charAt(i);
                }
            }
            
            k-=(maxIdx-start);
            
            start = maxIdx+1;
            answerLen --;
            
            sb.append(max);
            
        }
        
        return sb.toString();
        
    }
}