import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        
        int idx = 0;
        int cnt = 0;
        int sum = 0;
        int endTime = 0;
        
        while(cnt < jobs.length){
            
            while(idx < jobs.length && jobs[idx][0] <= endTime){
                pq.add(jobs[idx]);
                idx++;
            }
            
            if(pq.isEmpty()){
                endTime = jobs[idx][0];
                continue;
            }
            
            int[] task = pq.poll();
            sum += task[1] + (endTime - task[0]);
            endTime += task[1];
            cnt ++;
            
        }
        
        return sum/jobs.length;
        
    }
}