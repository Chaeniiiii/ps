import java.util.*;

class Solution {
    
    private static class Num{
        
        int idx;
        int n;
        
        private Num(int idx, int n){
            this.idx = idx;
            this.n = n;
        }
    }
    
    public int[] solution(int[] numbers) {
        
        PriorityQueue<Num> pq = new PriorityQueue<>((a,b) -> a.n - b.n);
        pq.add(new Num(0,numbers[0]));
        
        int[] result = new int[numbers.length];
        Arrays.fill(result,-1);
        
        for(int i = 1; i < numbers.length; i++){
            
            int now = numbers[i];
            
            while(!pq.isEmpty()){
                Num prev = pq.peek();
                if(prev.n >= now) break;
                pq.poll();
                result[prev.idx] = now;
            }
            pq.add(new Num(i,now));
            
        }
        
        return result;
        
        
    }
}