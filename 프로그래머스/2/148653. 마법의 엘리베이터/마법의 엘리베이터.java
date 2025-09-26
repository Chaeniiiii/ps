import java.util.*;

class Solution {
    public int solution(int storey) {
        
        int[] num = new int[String.valueOf(storey).length()];
        int result = 0;
        
        String number = String.valueOf(storey);
        for(int i = 0; i < number.length(); i++){
            num[i] = number.charAt(i) - '0';
        }
            
        
        for(int i = num.length - 1; i >= 0; i--){
            
            int now = num[i];
            
            if(now > 5){
                result += (10 - now);
                if(i == 0) result++;
                else num[i - 1]++;
            }
            else if(now < 5){
                result += now;
            }
            else{
                result+=5;
                if(i == 0 || num[i-1] < 5){
                    continue;
                }
                if(num[i-1] >= 5){
                    num[i-1]++;
                }
            }
        }
        
        return result;
        
    }
}