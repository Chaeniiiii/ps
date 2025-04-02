import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        long total1 = 0, total2 = 0;
        
        for(int q : queue1) {
            q1.add(q);
            total1+=q;
        }
        for(int q : queue2) {
            q2.add(q);
            total2+=q;
        }
        
        if((total1+total2)%2 !=0) return -1; //두 큐 합이 홀수이면 합을 같게 만들 수 없음 

        long mid = (total1+total2)/2;
        
        int cnt = 0;
        while(cnt <= (q1.size()+q2.size())*4){
            
            if(total1 == total2) return cnt;
            else if(total1 > total2){
                int num = q1.poll();
                total2+=num;
                total1-=num;
                q2.add(num);
            }
            else {
                int num = q2.poll();
                total1+=num;
                total2-=num;
                q1.add(num);
            }
            
            cnt ++;
            
        }
        
        return -1;
    }
}