import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < B.length; i++){
            pq.add(B[i]);
        }        
        
        int score = 0;
        Arrays.sort(A);
        
        for(int i = 0; i < A.length; i++){
            if(pq.isEmpty()) break;
            int cnt = pq.poll();
            while(cnt <= A[i] && !pq.isEmpty()){
                cnt = pq.poll();
            }
            if(cnt > A[i]) score++;
        }

        return score;
        
    }
}