class Solution {
    public long solution(int r1, int r2) {
       
        long cnt = 0;
        
        for(int i = 1; i<=r2; i++){
            int max = (int) Math.floor(Math.sqrt((1.0*r2*r2) - (1.0*i*i)));
            int min = (int) Math.ceil(Math.sqrt((1.0*r1*r1) - (1.0*i*i)));
            
            cnt += (max-min + 1);
        }
        
        return cnt * 4;
        
    }
}