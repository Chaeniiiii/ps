import java.util.*;

public class Solution {
    public int[] solution(int [] arr) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(arr[0]);
        
        for(int i = 1 ; i < arr.length; i++){
            if(deque.peekLast() == arr[i]) continue;
            deque.add(arr[i]);
        }
        
        int[] result = new int[deque.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = deque.poll();
        }
        
        return result;
        
    }
}