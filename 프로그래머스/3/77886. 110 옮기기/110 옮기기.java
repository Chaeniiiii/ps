import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        int n = strArr.length;
        String[] result = new String[n];
        
        for(int i = 0; i<n; i++){
            
            String str = strArr[i];
            
            StringBuilder newStr = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            
            int cnt = 0;
            
            for (char c : str.toCharArray()) {
                sb.append(c);
                while (sb.length() >= 3 && sb.substring(sb.length() - 3).equals("110")) {
                    cnt++;
                    sb.delete(sb.length() - 3, sb.length());
                }
            }
            
            newStr.append(sb.toString());
            
            if(cnt == 0){
                result[i] = str;
                continue;
            }
            
            int idx = newStr.toString().lastIndexOf("0");
            if(idx == -1){
                newStr.insert(0,"110".repeat(cnt));    
            }
            else{
                newStr.insert(idx+1,"110".repeat(cnt));    
            }
            
            result[i] = newStr.toString();
            
        }
        
        
        return result;
        
    }
}