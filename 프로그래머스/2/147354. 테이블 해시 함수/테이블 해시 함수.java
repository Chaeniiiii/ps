import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (a,b) -> {
            if(a[col - 1] == b[col - 1]){
                return b[0] - a[0];
            }
            return a[col-1] - b[col-1];
        });
        
        int result = 0;
        int cnt;
        
        for(int i = row_begin - 1; i < row_end ; i++){
            cnt = 0;
            int mod = i + 1;
            
            for(int j = 0; j < data[i].length; j++){
                cnt += data[i][j] % mod;
            }
            result^=cnt;
        } 
        
        return result;
        
    }
}
