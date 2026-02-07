import java.util.*;

class Solution {
    
    private static final int size = 10;
    
    private static int[] info, result;
    private static int n, diff;
    
    public int[] solution(int n, int[] info) {
        
        this.info = info;
        this.n = n;
        
        diff = 0;
        result = new int[size+1];
        dfs(0,0,new int[size+1]);
        
        return diff == 0 ? new int[]{-1} : result;
        
    }
    
    private static void dfs(int st, int cnt, int[] lion){
        
        if(cnt > n) return;
        if(cnt == n){
            int l = 0, p = 0;
            for(int i = 0; i <= size; i++){
                if(info[i] == 0 && lion[i] == 0) continue;
                if(info[i] >= lion[i]) p += size - i;
                else l += size - i;
            }
            
            int newDiff = l - p;
            if(l > p){
                if(diff < newDiff){
                    diff = newDiff;
                }
                else if(diff == newDiff){
                   for(int i = size; i >= 0; i--){
                        if(lion[i] < result[i]){
                            return;
                        }
                       else if(lion[i] > result[i]) break;
                   }
                }
                else return;
                result = lion.clone();
            }
            
            return;
            
        }
        
        if(st > size) return;
        
        //이번 판 진다고 가정
        dfs(st+1,cnt,lion);
        //이번 판 이긴다고 가정
        int brw = st == size ? n - cnt : info[st] + 1;
        lion[st] = brw;
        dfs(st+1,cnt+brw,lion);
        lion[st] = 0;
        
    }
    
}