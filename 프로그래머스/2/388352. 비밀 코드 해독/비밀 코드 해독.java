import java.util.*;

class Solution {
    
    private static int result = 0;
    
    private static int[] ans;
    private static int[][] q;
    private static ArrayList<Integer> arr;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        boolean[] visited = new boolean[n+1];
        
        this.q = q;
        this.ans = ans;
        arr = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            arr.add(i);
        }
        
        dfs(0,0,new boolean[n+1]);
        return result;
        
    }
    
    private static void dfs(int dep, int st, boolean[] number){
        
        if(dep == 5){
            if(isPossible(number)) result++;
            return;
        }
        
        for(int i = st; i < arr.size(); i++){
            int now = arr.get(i);
            number[now] = true;
            dfs(dep+1,i+1,number);
            number[now] = false;
        }
        
    }
    
    private static boolean isPossible(boolean[] number){
        
        // ArrayList<Integer> numberArr = new ArrayList<>();
        // for(int i = 0; i < number.length; i++){
        //     if(!number[i]) continue;
        //     numberArr.add(i);
        //     System.out.printf("%d ",i);
        // }
        // System.out.println();
        
        for(int i = 0; i < q.length; i++){
            int cnt = 0;
            for(int j = 0; j < q[i].length; j++){
                int num = q[i][j];
                if(number[num]) cnt++;
            }
            if(cnt != ans[i]) return false;
        }
        
        return true;
        
    }
    
}