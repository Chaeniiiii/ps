import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
    
        int [] per1 = new int[]{1,2,3,4,5};
        int [] per2 = new int[]{2,1,2,3,2,4,2,5};
        int [] per3 = new int[]{3,3,1,1,2,2,4,4,5,5};

        int [] cnt = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            
            if(answers[i] == per1[i%per1.length]) cnt[0] ++;
            if(answers[i] == per2[i%per2.length]) cnt[1] ++;
            if(answers[i] == per3[i%per3.length]) cnt[2] ++;
            
        }
        
        int score = Math.max(Math.max(cnt[0],cnt[1]),cnt[2]);
    
        ArrayList<Integer> total = new ArrayList<>();
        
        for(int i = 0; i<3; i++){
            if(score == cnt[i]) total.add(i+1);
        }
        
        int [] result = new int[total.size()];
        for(int i = 0; i<total.size(); i++) result[i] = total.get(i);
           
        return result;
                
    }
}