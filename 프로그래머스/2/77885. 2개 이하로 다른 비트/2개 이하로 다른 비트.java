import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        
        long[] result = new long[numbers.length];
        
        for(int t = 0; t < numbers.length; t++){
            
            long num = numbers[t];
            String binary = Long.toBinaryString(num);
            
            int len = binary.length();
            
            int idx = len;
            
            for(int i = len - 1; i >= 0; i--){
                
                 if(binary.charAt(i) == '0'){
                     idx = i;
                     break;
                 }
                
            }
            
            StringBuilder sb = new StringBuilder();
            
            if(idx == len){
                sb.append("10").append(binary.substring(1));
            }
            else if(idx < len){                
                
                sb.append(binary.substring(0,idx)).append("1");
                if(idx+1 < len) sb.append("0").append(binary.substring(idx+2));
            }
            else{
                sb.append(binary.substring(0,idx)).append("1");
            }
            
            //System.out.println(sb.toString());
            result[t] = Long.parseLong(sb.toString(),2);
            
        }
        
        return result;
        
    }
}