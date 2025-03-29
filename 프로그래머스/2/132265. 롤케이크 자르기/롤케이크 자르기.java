import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int cnt = 0;
        Map<Integer,Integer> rightM = new HashMap<>();
        Map<Integer,Integer> leftM = new HashMap<>();
        
        for(int i : topping){
            rightM.put(i,rightM.getOrDefault(i,0)+1);            
        }
        
        for(int tp : topping){
    
            leftM.put(tp,leftM.getOrDefault(tp,0)+1);
            
            if(rightM.get(tp) == 1){
                rightM.remove(tp);
            }
            else rightM.put(tp,rightM.get(tp)-1);
            
            if(leftM.size() == rightM.size()) cnt++;
                
        }
        
        return cnt;
        
    }
}