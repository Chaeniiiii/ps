import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        
        long[] bansNum = new long[bans.length];
        for(int i = 0; i < bans.length; i++){
            bansNum[i] = convertNum(bans[i]);
        }
        
        Arrays.sort(bansNum);

        for(long ban : bansNum){
            if(ban <= n) n++;
        }
        
        return convertStr(n);
        
    }
    
    private static long convertNum(String str){
        
        int len = str.length();
        long cnt = 0;
        
        for(int i = 0; i < len; i++){
            
            cnt += (long)(str.charAt(i) - 'a' + 1) * Math.pow(26,len - i - 1);
            
        }
        
        return cnt;
        
    }
    
    private static String convertStr(long num){
        
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            
            num--;
            int mod = (int)(num % 26);
            sb.append((char)('a' + mod));
            num /= 26;
            
        }
        
        return sb.reverse().toString();
        
    }
}