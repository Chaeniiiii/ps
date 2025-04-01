class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        while(sb.toString().length() < t*m){
            sb.append(Integer.toString(idx,n).toUpperCase());
            idx ++;
        }
        
        String number = sb.toString();
        sb = new StringBuilder();
        
        idx = p-1;
        while(sb.toString().length() < t){
            
            if(idx >= number.length()) break;

            sb.append(number.charAt(idx));
            idx += m;
            
        }
        
        return sb.toString();
        
    }
}