import java.util.*;

class Solution {
    public int solution(int[] a) {
        
        int n = a.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        
        int min = a[0];
        prev[0] = min;
        
        for(int i = 0; i < n; i++){
            if(a[i] < min) min = a[i];
            prev[i] = min;    
        }
        
        min = a[n - 1];
        for(int i = n - 1; i >= 0; i--){
            if(a[i] < min) min = a[i];
            next[i] = min;
        }
        
        int result = 0;
        for(int i = 0; i < n; i++){
            if(prev[i] == a[i] || next[i] == a[i]) result++;   
        }
        
        return result;
    }
}