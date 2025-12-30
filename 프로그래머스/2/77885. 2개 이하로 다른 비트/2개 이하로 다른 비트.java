import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            
            long number = numbers[i];
            String str = Long.toBinaryString(number);
            
            StringBuilder sb = new StringBuilder();
            for(char c : str.toCharArray()){
                sb.append(c);
            }
            
            int idx = sb.toString().length() - 1;
            int zero = -1;
            
            for(; idx >= 0; idx--){
                if(sb.charAt(idx) == '1') break;
                else zero = Math.max(zero,idx);
            }
            
            if(idx < zero){
                sb.setCharAt(zero,'1');
            } 
            else{
                for(int j = 0; j < idx; j++){
                    if(sb.charAt(j) == '0') zero = Math.max(zero,j);
                }
                
                if(zero == -1){
                    sb.setCharAt(0,'0');
                    sb = sb.reverse();
                    sb.append('1');
                    sb = sb.reverse();
                    
                }
                else{
                    sb.setCharAt(zero,'1');
                    sb.setCharAt(zero+1,'0');
                }
                
            }
            answer[i] = Long.valueOf(sb.toString(), 2);
        }
        
        return answer;
        
    }
}