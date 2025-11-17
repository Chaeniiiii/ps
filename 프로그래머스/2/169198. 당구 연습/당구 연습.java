import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int[] result = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int ballX = balls[i][0];
            int ballY = balls[i][1];
            
            double x = startX - ballX;
            double y = startY - ballY;
            
            double l = Math.pow((startX + ballX),2) + Math.pow(y,2);
            double r = Math.pow((m - startX) + (m - ballX),2) + Math.pow(y,2);
            
            double d = Math.pow((startY + ballY),2) + Math.pow(x,2);
            double t = Math.pow((n - startY) + (n - ballY),2) + Math.pow(x,2);
           
            
            int minV = (int)Math.min(Math.min(l,r),Math.min(d,t));
            if(x == 0){
                if(y > 0){
                    minV = (int)Math.min(Math.min(l,r),t);
                }
                else{
                    minV = (int)Math.min(Math.min(l,r),d);
                }
            }
            else if(y == 0){
                if(x > 0){
                    minV = (int)Math.min(Math.min(d,t),r);
                }
                else{
                    minV = (int)Math.min(Math.min(d,t),l);
                }
            }
            
            result[i] = minV;
            
        }
        
        return result;
        
    }
}