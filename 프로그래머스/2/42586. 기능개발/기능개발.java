import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int n = progresses.length, cnt = 1, prev = calc(progresses[0],speeds[0]);
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1; i < n; i++){
            
            int now = calc(progresses[i],speeds[i]);
            if(now <= prev){
                cnt++;
            }
            else{
                arr.add(cnt);
                prev = now;
                cnt = 1;
            }
            
            if(i == n - 1) arr.add(cnt);
            
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
    
    private static int calc(int prg, int spd){
        
        prg = 100 - prg;
        int p = prg / spd;
        int d = prg % spd;
        
        return p + (d == 0 ? 0 : 1);
        
    }
}