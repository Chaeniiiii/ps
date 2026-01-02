import java.util.*;

class Solution {
    
    private static final int MAX = 300_000;
    
    public int solution(int[] queue1, int[] queue2) {
        
        long sum1 = 0, sum2 = 0, n = queue1.length;
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            deque1.add(queue1[i]);
            deque2.add(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        
        if((sum1 + sum2) % 2 != 0) return -1;
                
        int c = MAX * 3, cnt = 0;
        while(c-- > 0){
            if(sum1 < sum2){
                int ele = deque2.poll();
                deque1.add(ele);
                sum1 += ele;
                sum2 -= ele;
            }
            else if(sum1 > sum2){
                int ele = deque1.poll();
                deque2.add(ele);
                sum1 -= ele;
                sum2 += ele;
            }
            else return cnt;
            cnt++;
            
        }
        
        return -1;
        
    }
}