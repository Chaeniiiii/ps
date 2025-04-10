import java.util.*;

class Solution {
    
    private static class Pos {
        int x ;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int[][] arr) {
        
        int n = arr.length;
        int [] result = new int[2];
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0));
        
        while(n > 0){
            
            int size = deque.size();
            
            for(int t = 0; t<size; t++){
                
                Pos now = deque.poll();
                
                if(divide(now,arr,n)) result[arr[now.x][now.y]]++;
                else{
                    for(int i = now.x; i<now.x+n; i+=(n/2)){
                        for(int j = now.y; j<now.y+n; j+=(n/2)){
                            deque.add(new Pos(i,j));
                        }
                    }
                }
            }
            
            
            n /= 2;
            
        }
        
        return result;
        
    }
    
    private static boolean divide(Pos pos,int[][] arr,int len){
        
        int now = arr[pos.x][pos.y];
        
        for(int i = pos.x; i<pos.x+len; i++){
            for(int j = pos.y; j<pos.y+len; j++){
                if(arr[i][j] != now) return false;
            }
        }
        
        return true;
        
    }
    
}