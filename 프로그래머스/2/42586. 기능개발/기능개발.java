import java.util.*;

class Solution {
    private static final int SUCCESS = 100;
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        int max = (SUCCESS-progresses[0])/speeds[0];
        if((SUCCESS-progresses[0])%speeds[0] != 0) max++;
        
        int cnt = 1;
        
        for(int i = 1 ; i<progresses.length; i++){
            int num = (SUCCESS-progresses[i])/speeds[i];
            int div = (SUCCESS-progresses[i])%speeds[i];
            
            if(div != 0) num++;
            
            if(num <= max) cnt ++;
            else{
                arr.add(cnt);
                max = num;
                cnt = 1;
            }
        }
        
        arr.add(cnt);
        
        int [] result = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++) result[i] = arr.get(i);
        
        return result;
       
    }
}