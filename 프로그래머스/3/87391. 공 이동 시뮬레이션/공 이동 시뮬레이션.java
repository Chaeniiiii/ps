import java.util.*;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        
        long lt = y, rt = y, top = x, bt = x;
        
        for(int i = queries.length - 1; i >=0; i--){
            
            int dir = queries[i][0];
            int dist = queries[i][1];
            
            if(dir == 0){ //left
                if(lt != 0){
                    lt+=dist;
                }
                rt = Math.min(m-1,rt+dist);
            }
            else if(dir == 1){ //right
                if(rt != m-1){
                    rt-=dist;
                }
                lt = Math.max(0,lt-dist);
            }
            else if(dir == 2){ //top
                if(top != 0){
                    top+=dist;
                }
                bt = Math.min(n-1,bt+dist);
            } 
            else if(dir == 3){ //bottom
                if(bt != n-1){
                    bt-=dist;
                }
                top = Math.max(0,top-dist);
            }
            
            if(lt >= m || rt < 0 || top >= n || bt < 0) return 0;
            
        }
        
        return (rt-lt+1) * (bt-top+1);
        
    }
}