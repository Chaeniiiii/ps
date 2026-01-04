import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
       String[] arr = Arrays.stream(numbers)
                     .mapToObj(String::valueOf)
                     .toArray(String[]::new);

         
        Arrays.sort(arr,(a,b) -> {
            return (b+a).compareTo(a+b);
        });
        
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(Integer.parseInt(str));
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
        
    }
}