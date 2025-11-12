import java.util.*;
import java.util.stream.*;

class Solution {
    
    private static final long MAX = 300_000;
    public int solution(int[] queue1, int[] queue2) {
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if((sum1+sum2)%2 != 0) return -1;
        
        int n = queue1.length;
        Deque<Long> deque1 = new ArrayDeque<>();
        Deque<Long> deque2 = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            deque1.add((long)queue1[i]);
            deque2.add((long)queue2[i]);
        }
        
        int cnt = 0;
        while(cnt < MAX){
            
            long num;
            if(sum1 > sum2){
                num = deque1.poll();
                sum2+=num;
                sum1-=num;
                deque2.add(num);
            }
            else if(sum1 < sum2){
                num = deque2.poll();
                sum1+=num;
                sum2-=num;
                deque1.add(num);
            }
            else{
                return cnt;
            }
            cnt++;
        }
        
        return -1;
        
    }
}