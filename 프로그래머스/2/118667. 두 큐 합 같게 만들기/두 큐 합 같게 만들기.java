import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        long sum1 = 0, sum2 = 0;
        Deque<Integer> deque1 = new ArrayDeque<>();
        for(int i = 0; i < queue1.length; i++){
            deque1.add(queue1[i]);
            sum1+=queue1[i];
        }
        
        Deque<Integer> deque2 = new ArrayDeque<>();
        for(int i = 0; i < queue2.length; i++){
            deque2.add(queue2[i]);
            sum2+=queue2[i];
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        
        int idx = 0, cnt = 0, total = deque1.size() + deque2.size();
        while(idx++ <= total * 2){
            if(sum1 < sum2){
                int num = deque2.poll();
                deque1.add(num);
                sum1+=num;
                sum2-=num;
            }
            else if(sum1 > sum2){
                int num = deque1.poll();
                deque2.add(num);
                sum2+=num;
                sum1-=num;
            }
            else{
                return cnt;
            }
            cnt++;
        }
        
        return -1;
        
    }
    
}