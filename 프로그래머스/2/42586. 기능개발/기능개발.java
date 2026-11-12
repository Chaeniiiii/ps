import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> arr = new ArrayList<>();
        
        int n = progresses.length;
        int idx = 0;
        
        while(idx < n){
            
            int cnt = 0;
            int now = getDay(100 - progresses[idx], speeds[idx]);
            
            for(int i = idx + 1; i < n; i++){
                int nxt = getDay(100 - progresses[i], speeds[i]);
                if(nxt <= now) cnt++;
                else break;
            }
            
            idx += (cnt + 1);
            arr.add(cnt + 1);
            
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
    
    private int getDay(int d , int s){
        
        return (d / s) + (d % s > 0 ? 1 : 0);
        
    }
}