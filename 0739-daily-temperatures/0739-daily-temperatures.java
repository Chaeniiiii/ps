import java.util.*;

class Solution {

    private static class Temp {
        int idx;
        int t ;

        private Temp(int idx, int t){
            this.idx = idx;
            this.t = t;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        
        PriorityQueue<Temp> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));
        pq.add(new Temp(0,temperatures[0]));

        int [] result = new int[temperatures.length];
        
        for(int i = 1; i<temperatures.length; i++){
            
            Temp temp = new Temp(i,temperatures[i]);
            
            while(!pq.isEmpty()){

                if(pq.peek().t >= temp.t) break;

                Temp prev = pq.poll();
                result[prev.idx] = temp.idx - prev.idx;

            }

            pq.add(temp);

        }

        return result;

    }
}