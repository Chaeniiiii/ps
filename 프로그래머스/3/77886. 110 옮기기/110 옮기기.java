import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        
        String[] result = new String[s.length];
        for(int t = 0; t < s.length; t++){
            result[t] = solve(s[t]);
        }        
        
        return result;
        
    }
    
    private String solve(String str){

        StringBuilder sb = new StringBuilder();
        StringBuilder ooz = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            sb.append(c);
            if(sb.length() > 2 && sb.charAt(sb.length()-3)=='1' && sb.charAt(sb.length()-2)=='1'  && sb.charAt(sb.length()-1)=='0') {
                sb.delete(sb.length() - 3, sb.length());
                ooz.append("110");
            }
        }
        
        if(ooz.length() > 0){
            int idx = sb.lastIndexOf("0");
            if(idx == -1){
                sb.insert(0,ooz.toString());
            }
            else{
                sb.insert(idx+1, ooz.toString());
            }
        }
        
        return sb.toString();
        
    }
    
}