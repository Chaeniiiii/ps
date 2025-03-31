import java.util.*;

class Solution {
    
    private static class Num {
        
        int idx;
        int n;
        
        private Num(int n,int idx){
            this.n=n;
            this.idx=idx;
        }
        
        private int getNum(){
            return n;
        }
    }
    
    public int[] solution(int[] numbers) {
        
        PriorityQueue<Num> pq = new PriorityQueue<>(Comparator.comparingInt(Num::getNum));
        int [] result = new int[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            
            int now = numbers[i];
            
            if(pq.isEmpty() || pq.peek().n >= now) {
                pq.add(new Num(now,i));
                continue;
            }
            
            while(true){
                if(pq.isEmpty() || pq.peek().n >= now) break;
                Num prev = pq.poll();
                result[prev.idx] = now;
            }
            pq.add(new Num(now,i));
            
        }
        
        for(Num num : pq) result[num.idx] = -1;
        
        return result;
    }
}