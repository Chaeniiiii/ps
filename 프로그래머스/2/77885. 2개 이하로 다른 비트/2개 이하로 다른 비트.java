import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        
        long[] result = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            if(num % 2 == 0){
                result[i] = num + 1;
            }
            else{
                long bit = (num ^ (num + 1)) >> 2;
                result[i] = num + bit + 1;
            }
        }
        
        return result;
        
    }
}