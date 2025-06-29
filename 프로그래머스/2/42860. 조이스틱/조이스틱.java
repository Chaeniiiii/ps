import java.util.*;

class Solution {
    public int solution(String name) {
        
        int result = 0;
        int mvCnt = name.length() - 1;

        for(int i = 0 ; i < name.length(); i++){
            
            result += Math.min((int)(name.charAt(i) - 'A') , 'Z' - name.charAt(i) + 1);
            
            int nxtIdx = i + 1;
            
            while(nxtIdx < name.length() && name.charAt(nxtIdx) == 'A'){
                nxtIdx ++;
            }
            
            mvCnt = Math.min(mvCnt, Math.min(i * 2 + (name.length() - nxtIdx), i + (name.length() - nxtIdx) * 2));
            
        }
        
        return result + mvCnt;
        
    }
}