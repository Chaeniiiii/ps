import java.util.*;

class Solution {
    
    private static class Num {
        
        int idx;
        int n;
        
        private Num(int idx, int n){
            this.idx = idx;
            this.n = n;
        }
        
    }
    
    public int[] solution(int[] prices) {
        
        Deque<Num> deque = new ArrayDeque<>();
        int [] result = new int[prices.length];
        
        for(int i = 0; i<prices.length; i++){
            
            Num num = new Num(i,prices[i]);
            int size = deque.size();
            
            for(int s = 0 ; s<size; s++){
                Num next = deque.poll();
                
                if(next.n <= num.n) deque.add(next);
                result[next.idx]++;
                
            }
            
            deque.add(num);
            
        }
                                                    
        return result;
        
    }
}