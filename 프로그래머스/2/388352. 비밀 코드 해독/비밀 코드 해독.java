import java.util.*;

class Solution {
    
    private int n, size, cnt;
    private int[][] q;
    private int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        cnt = 0;
        size = q[0].length;
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        dfs(1, new ArrayList<>());
        return cnt;
        
    }
    
    private void dfs(int idx, ArrayList<Integer> arr){
        
        if(arr.size() == size){
            if(isPossible(arr)){
                cnt++;
                return;
            }
        }
        
        for(int i = idx; i <= n; i++){
            arr.add(i);
            dfs(i+1,arr);
            arr.remove(arr.size() - 1);
        }
        
    }
    
    private boolean isPossible(ArrayList<Integer> arr){
        
        for(int i = 0; i < q.length; i++){
            int[] number = q[i];
            int cnt = 0;
            for(int j = 0 ; j < size; j++){
                int num = number[j];
                for(int k = 0; k < size; k++){
                    if(num == arr.get(k)) cnt++;
                }
            }
            
            if(ans[i] != cnt) return false;
            
        }
        
        return true;
        
    }
    
}