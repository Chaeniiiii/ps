import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
         
        int cnt = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < B.length; i++){
            deque.add(B[i]);
        }
        
        for(int i = A.length - 1; i >= 0; i--){
            if(A[i] >= deque.peekLast()){
                deque.poll();
            }
            else{
                deque.pollLast();
                cnt++;
            }
        }
        
        return cnt;
        
    }
}