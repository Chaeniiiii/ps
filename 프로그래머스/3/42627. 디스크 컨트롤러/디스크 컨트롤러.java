import java.util.*;

class Solution {
    
    private class Task{
        int idx; //작업 번호
        int st; //요청 시각
        int cool; //소요 시간 
        
        private Task(int idx, int st, int cool){
            this.idx = idx;
            this.st = st;
            this.cool = cool;
        }
    }
    
    public int solution(int[][] jobs) {
        
        int[] endTime = new int[jobs.length];
        
        //우선순위대로 각 작업을 정렬
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            if(a.cool == b.cool){
                if(a.st == b.st){
                    return a.idx - b.idx;
                }
                return a.st - b.st;
            }
            return a.cool - b.cool;
        });
        
        //작업이 시작되는 순으로 배열 정렬
        ArrayList<Task> arr = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++){
            arr.add(new Task(i,jobs[i][0],jobs[i][1]));
        }
        
        arr.sort((a,b) -> a.st - b.st);
        
        int idx = 0;
        int cnt = 0;
        int time = 0;
        
        while(cnt < arr.size()){
            
            while(idx < arr.size() && arr.get(idx).st <= time){
                pq.add(arr.get(idx));
                idx++;
            }
            
            if(pq.isEmpty()){
                time = arr.get(idx).st;
            }
            else{
                Task now = pq.poll();
                time += now.cool;
                endTime[now.idx] = time - now.st;
                cnt++;
            }
            
        }
        
        return Arrays.stream(endTime).sum() / endTime.length;
        
    }
}