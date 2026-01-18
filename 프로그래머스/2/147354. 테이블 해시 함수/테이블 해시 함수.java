import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int c = col-1;
        int rb = row_begin - 1;
        int re = row_end - 1;
        
        //1. data col 열을 기준으로 정렬 
        Arrays.sort(data, (a,b) -> {
            if(a[c] == b[c]){
                return b[0] - a[0];
            }
            return a[c] - b[c];
        });
        
        int[] div = new int[re - rb + 1];
        int idx = 0;
        for(int i = rb; i <= re; i++){
            div[idx] = mod(data[i], i+1);
            idx++;
        }
        
        int result = div[0];
    
        for(int i = 1; i < div.length; i++){
            result ^= div[i];
        }
        
        return result;
        
    }
    
    private static int mod(int[] d, int i){
        
        int sum = 0;
        for(int k = 0; k < d.length; k++){
            sum+=d[k] % i;
        }
        
        return sum;
        
    }
    
}