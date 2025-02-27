class Solution {
    public int[] solution(String s) {
        
        int cycle = 0 , cnt = 0;
        
        while(!s.equals("1")){
            
            int nowLen = s.length();
            s = s.replaceAll("0","");
            int nextLen = s.length();
            
            cnt += (nowLen - nextLen);
            s = Integer.toBinaryString(nextLen);
            
            cycle ++;
            
        }        
        
        return new int[]{cycle,cnt};
        
    }
}