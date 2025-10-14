import java.util.*;

class Solution {
    
    private static final int size = 26;
    
    public String solution(long n, String[] bans) {
        
        long[] bansNum = new long[bans.length];
        for(int i = 0; i < bans.length; i++){
            String str = bans[i];
            long num = 0;
            for(int j = 0; j < str.length(); j++){
                num += (str.charAt(j) - 'a' + 1) * Math.pow(26,str.length() - 1 - j);
            }
            bansNum[i] = num;
        }
        
        Arrays.sort(bansNum);
        for(int i = 0; i < bansNum.length; i++){
            if(bansNum[i] <= n) n++;
        }
        
        System.out.println(n);
        
        return convert(n);
        
    }
    
    private static String convert(long num){
        
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            
            num--;
            int mod = (int)(num % size);
            sb.append((char)('a' + mod));
            num /= size;
            
        }
        
        return sb.reverse().toString();
        
    }
}