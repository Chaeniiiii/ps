import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int an = arr1.length;
        int am = arr1[0].length;
        
        int bm = arr2[0].length;
        
        int[][] result = new int[an][bm];
        for(int i = 0; i < an; i++){
            for(int j = 0; j < bm; j++){
                for(int k = 0; k < am; k++){
                    result[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        
        return result;
        
    }
}