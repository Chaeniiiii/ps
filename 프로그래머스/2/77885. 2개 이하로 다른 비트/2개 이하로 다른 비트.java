import java.util.*;

class Solution {
    
    
    public long[] solution(long[] numbers) {
        
        long[] result = new long [numbers.length];
        
        for(int t = 0; t<numbers.length; t++){
            
            long num = numbers[t];
            StringBuilder bitNum = new StringBuilder(Long.toBinaryString(num));
            
            if(bitNum.charAt(bitNum.length()-1) == '0'){
                bitNum.setCharAt(bitNum.length()-1,'1');
            }
            else if(bitNum.toString().contains("0")){
                for(int i = bitNum.length()-1; i>=0; i--){
                    if(bitNum.charAt(i) == '0'){
                        bitNum.setCharAt(i,'1');
                        bitNum.setCharAt(i+1,'0');
                        break;
                    }
                }
            }
            else {
                bitNum.setCharAt(0,'0');
                bitNum.insert(0,'1');
            }
            
            result[t] = Long.parseLong(bitNum.toString(),2);
            
            
        }
        
        return result;
        
    }
}