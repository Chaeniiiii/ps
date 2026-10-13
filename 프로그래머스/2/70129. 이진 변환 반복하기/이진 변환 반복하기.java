import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] result = new int[2];
        while(!s.equals("1")){
            
            int cnt = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') cnt++;
            }
            
            result[1] += cnt;
            s = s.replace("0","");
            
            s = toBinary(s.length());
            result[0]++;
        }
        
        return result;
        
    }
    
    private String toBinary(int num){
        
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
                 
            sb.append(num % 2);
            num /= 2;
            
        }
        
        return sb.reverse().toString();
        
    }
}