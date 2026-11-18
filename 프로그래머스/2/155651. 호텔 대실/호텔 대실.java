import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        
        int n = book_time.length;
        int[][] time = new int[n][2];
        for(int i = 0; i < n; i++){
            int st = getTime(book_time[i][0]);
            int en = getTime(book_time[i][1]);
            
            time[i][0] = st;
            time[i][1] = en;
        }
        
        Arrays.sort(time,(a,b) -> a[0] - b[0]);
        for(int i = 0; i < time.length; i++){
            if(pq.isEmpty()) pq.add(time[i][1]);
            else if(pq.peek() > time[i][0]) pq.add(time[i][1]);
            else if(pq.peek() + 10 <= time[i][0]){
                pq.poll();
                pq.add(time[i][1]);
            }
            else{
                pq.add(time[i][1]);
            }
        }
        
        return pq.size();
    }
    
    private int getTime(String t){
        
        String[] time = t.split(":");
        int h = Integer.parseInt(time[0]) * 60;
        int m = Integer.parseInt(time[1]);
        
        return h + m;
    }
    
}