import java.util.*;

class Solution {
    
    private static int n;
    private static int[][] arr;
    
    private static class Pos{

        int x, y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
            
    }
    
    public int[] solution(int[][] arr) {
        
        this.arr = arr;
        n = arr.length;
        int[] result = new int[2];
        
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0));
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int t = 0; t < size; t++){
                
                Pos pos = deque.poll();
                
                if(div(pos)){
                    result[arr[pos.x][pos.y]]++;
                }
                else{
                    for(int i = pos.x; i < pos.x + n; i += n/2){
                        for(int j = pos.y ; j < pos.y + n; j += n/2){
                            deque.add(new Pos(i,j));
                        }
                    }
                }
            }
            
            n /= 2;
        }
        
        return result;
        
    }
    
    private static boolean div(Pos pos){
        
        int origin = arr[pos.x][pos.y];
        
        for(int i = pos.x; i < pos.x + n; i++){
            for(int j = pos.y; j < pos.y + n; j++){
                if(arr[i][j] != origin) return false;
            }
        }
        
        return true;
        
    }
}