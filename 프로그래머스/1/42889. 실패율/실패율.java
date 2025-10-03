import java.util.*;

class Solution {
    
    private static class Fail{
        
        int stage;
        double percent;
        
        private Fail(int stage, double percent){
            this.stage = stage;
            this.percent = percent;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        int M = stages.length;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i<=N+1; i++){
            map.put(i,0);
        }
        
        for(int stage : stages){
            map.put(stage,map.get(stage)+1);
        }
        
        PriorityQueue<Fail> pq = new PriorityQueue<>((a,b) -> {
            int cmp = Double.compare(b.percent,a.percent);
            if(cmp == 0) return a.stage - b.stage;
            return cmp;
        });
        
        int member = M;
        for(int key = 1; key <= N; key++){
            
            int now = map.get(key);
            
            double failuer = now == 0 ? 0.0 : (double)now/member;
            pq.add(new Fail(key,failuer));
            
            member -= now;
            
        }
        
        int[] result = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx] = pq.poll().stage;
            idx++;
        }
        
        return result;
        
        
        
    }
}