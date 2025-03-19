import java.util.*;

class Solution {
    
    public int solution(int[] order) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        int size = order.length;
        
        int num = 1; //택배상자 번호
        int cnt = 0; //실린 택배 개수
        
        for(int i = 0; i<size; i++){
            
            int now = order[i];
            
            while(num <= now){
                deque.add(num);
                num ++;
            }

            // System.out.println(new ArrayList<>(deque).toString());
            
            if(deque.pollLast() != now) break;
            if(num > size + 1) break;
                
            cnt ++;
            
        }
        
        return cnt;
        
    }
}