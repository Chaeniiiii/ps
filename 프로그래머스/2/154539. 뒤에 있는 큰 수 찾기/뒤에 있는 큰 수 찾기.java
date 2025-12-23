import java.util.*;

class Solution {
    
    private static class Num{
        int n;
        int idx;
        private Num(int n, int idx){
            this.n = n;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] numbers) {
        
        int[] result = new int[numbers.length];
        PriorityQueue<Num> pq = new PriorityQueue<>((a,b) -> a.n - b.n);
        pq.add(new Num(numbers[0],0));
        
        for(int i = 1; i < numbers.length; i++){
            
            int num = numbers[i];
            while(!pq.isEmpty()){
                
                if(pq.peek().n >= num) break;
                result[pq.poll().idx] = num;
                
            }
            
            pq.add(new Num(num,i));
            
        }
        
        while(!pq.isEmpty()){
            result[pq.poll().idx] = -1;
        }
        
        return result;
        
    }
}