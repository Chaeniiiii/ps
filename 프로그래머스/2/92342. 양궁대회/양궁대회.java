import java.util.*;

class Solution {
    
    private static final int size = 10;
    private static int n,result;
    private static int[] info;
    private static int[] lion;
    
    public int[] solution(int n, int[] info) {
    
        this.n = n;
        this.info = info;
        
        result = -1;
        lion = new int[size + 1];
        
        dfs(0,0,new int[size + 1]);
        
        return result == -1 ? new int[]{-1} : lion;
    }
    
    private static void dfs(int idx, int dep, int[] newArr){
        
        int[] arr = newArr.clone();
        
        if(dep == n){
            calc(arr);
            return;
        }
        
        for(int i = idx; i <= size; i++){
            
            arr[i]++;
            if(arr[i] <= info[i] + 1) dfs(i,dep+1,arr);
            arr[i]--;
            
        }
        
    }
    
    private static void calc(int[] newArr){
        
        int a = 0;
        int b = 0;
        for(int i = 0; i <= size; i++){
            if(info[i] == 0 && newArr[i] == 0) continue;
            if(info[i] < newArr[i]) a+=size-i;
            else b += size-i;
        }
        
        int newScore = a <= b ? -1 : a - b;
        if(newScore == -1) return;
        
        if(result < newScore){
            lion = newArr.clone();
            result = newScore;
        }
        else if(result == newScore){
            for(int i = size; i >= 0; i--){
                if(newArr[i] > lion[i]){
                    lion = newArr.clone();
                    break;
                }
                else if(newArr[i] < lion[i]){
                    break;
                }
            }
            result = newScore;
        }
        
    }
    
}