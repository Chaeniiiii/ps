import java.util.*;

class Solution {
    public int[] solution(int m, int n, int stx, int sty, int[][] balls) {
        
        int[] result = new int[balls.length];
        
        for(int t = 0; t < balls.length; t++){
            
            int tx = balls[t][0];
            int ty = balls[t][1];
            int min = Integer.MAX_VALUE;
            
            //우측 벽을 기준으로 대칭 
            if(!(stx < tx && sty == ty)){
                int calc = (int)(Math.pow((m-stx)+(m-tx),2) + Math.pow(Math.abs(sty - ty),2));
                min = Math.min(min,calc);    
            }
            
            //좌측 벽을 기준으로 대칭
            if(!(stx > tx && sty == ty)){
                int calc = (int)(Math.pow(stx+tx,2) + Math.pow(Math.abs(sty - ty),2));
                min = Math.min(min,calc);
            }
            
            //아래 벽을 기준으로 대칭
            if(!(stx == tx && sty > ty)){
                int calc = (int)(Math.pow(sty+ty,2) + Math.pow(Math.abs(stx - tx),2));
                min = Math.min(min,calc);
            }
            
            //위 벽을 기준으로 대칭
            if(!(stx == tx && sty < ty)){
                int calc = (int)(Math.pow((n-sty) + (n-ty),2) + Math.pow(Math.abs(stx - tx),2));
                min = Math.min(min,calc);
            }
            
            result[t] = min;
            
        }
        
        return result;
        
    }
}