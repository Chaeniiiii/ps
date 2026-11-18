import java.util.*;

class Solution {
    
    private int[] num;
    
    public int[] solution(int[][] arr) {
        
        int size = arr.length;
        num = new int[2];
        
        quad(0,0,size,arr);
        return num;
    }
    
    private void quad(int x, int y, int size, int[][] arr){
        
        if(check(x,y,size,arr)){
            num[arr[x][y]]++;
            return;
        }
        
        quad(x,y,size/2,arr);
        quad(x + size / 2,y,size/2,arr);
        quad(x,y + size / 2,size/2,arr);
        quad(x+ size / 2,y+ size / 2,size/2,arr);
        
    }
    
    private boolean check(int x, int y, int size, int[][]arr){
        
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        
        return true;
        
    }
    
}