import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[] newP = priorities.clone();
        Arrays.sort(newP);
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            deque.add(i);
        }
        
        int pIdx = newP.length - 1, idx, cnt = 0;
        while(!deque.isEmpty()){
            
            idx = deque.poll();
            if(idx == location && newP[pIdx] == priorities[idx]) return cnt + 1;
            if(newP[pIdx] > priorities[idx]) deque.add(idx);
            else{
                pIdx--;
                cnt++;
            }
        }
        
        return cnt;
        
    }
}