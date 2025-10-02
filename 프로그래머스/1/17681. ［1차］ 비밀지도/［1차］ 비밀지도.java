import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] result = new String[n];
        StringBuilder sb;
        
        for(int i = 0; i < n; i++){
            
            sb = new StringBuilder();
            String bit1 = Integer.toBinaryString(arr1[i]);
            String bit2 = Integer.toBinaryString(arr2[i]);
            
            if(n > bit2.length()){
                bit2 = "0".repeat(n - bit2.length()) + bit2;
            }
            if(n > bit1.length()){
                bit1 = "0".repeat(n - bit1.length()) + bit1;
            }
            
            for(int j = 0; j < bit1.length(); j++){
                int num = (bit1.charAt(j) - '0') | (bit2.charAt(j) - '0');
                if(num == 1) sb.append("#");
                else sb.append(" ");
            }
            
            result[i] = sb.toString();
            
        }
        
        return result;
    }
}