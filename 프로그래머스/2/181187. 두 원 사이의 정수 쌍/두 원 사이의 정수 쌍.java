class Solution {
    public long solution(int r1, int r2) {
       
        long cnt = 0;
        
        for(int x = 1; x <= r2; x++){
            int maxY = (int) Math.floor(Math.sqrt((1.0 * r2*r2) - (1.0 * x * x)));
            int minY = (int) Math.ceil(Math.sqrt((1.0 * r1*r1) - (1.0 * x * x)));
            
            cnt += (maxY - minY + 1);
        }
        
        return cnt * 4;
        
    }
}