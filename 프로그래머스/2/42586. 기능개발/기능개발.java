import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int cnt = 0;
        int maxT = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int remain = (100 - progresses[i]);
            int time = remain / speeds[i] + (remain % speeds[i] > 0 ? 1 : 0);
            if(cnt == 0 || maxT >= time){
                cnt++;
                maxT = Math.max(maxT,time);
            }
            else{
                maxT = time;
                arr.add(cnt);
                cnt = 1;
            }
        }
        
        if(cnt != 0) arr.add(cnt);
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
}