import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 1, cnt = 0;
            
        for(int i = 0 ; i < order.length; i++){
            while(num <= order[i]){
                deque.add(num);
                num++;
            }
            if(deque.isEmpty()) break;
            if(deque.peekLast() == order[i]){
                deque.pollLast();
                cnt++;
            }
            else if(deque.peekLast() > order[i]) break;
        }
            
        return cnt;
        
    }
}