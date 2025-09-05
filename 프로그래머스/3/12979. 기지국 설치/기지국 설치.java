class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int cnt = w * 2 + 1; 
        int result = 0;
        
        for(int i = 0; i <= stations.length; i++){
    
            int len = 0;
            
            if(i == 0){
                len = stations[i] - w - 1;
            }
            else if(i == stations.length){
                len = n - stations[i-1] - w;
            }
            else{
                len = stations[i] - stations[i-1] - (w*2) - 1;
            }
            
            if(len >= 0){
                result += len / cnt;
                if(len % cnt != 0) result++;
            }
            
        }

        return result;
    }
}