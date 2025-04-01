class Solution {
    public String solution(int n, int t, int m, int p) {
        
        String number = "";
        String answer = "";
        int idx = 0;
        
        while(number.length() < t*m){
            number += Integer.toString(idx,n).toUpperCase();
            idx ++;
        }
        
        // System.out.println(number);
        
        idx = p-1;
        while(answer.length() < t){
            
            if(idx >= number.length()) break;

            answer+=number.charAt(idx);
            idx += m;
            
        }
        
        return answer;
        
    }
}