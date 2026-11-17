import java.util.*;

class Solution {
    
    private int result;
    private boolean[] visited;
    
    public int solution(int x, int y, int n) {
        
        visited = new boolean[y+1];
        result = Integer.MAX_VALUE;
        return bfs(x,y,n);
        
    }
    
    private int bfs(int x, int y, int n){
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);
        
        int cnt = 0;
        visited[x] = true;
            
        while(!deque.isEmpty()){
            
            int size = deque.size();
            for(int i = 0; i < size; i++){
                int now = deque.poll();
                
                if(now == y) return cnt;
                if(now > y) continue;
                
                if(now + n <= y && !visited[now+n]){
                    visited[now+n] = true;
                    deque.add(now + n);
                }
                if(now * 3 <= y && !visited[now*3]){
                    visited[now*3] = true;
                    deque.add(now * 3);
                }
                if(now * 2 <= y && !visited[now*2]){
                    visited[now*2] = true;
                    deque.add(now * 2);
                }
            }
            
            cnt++;
            
        }
        
        return -1;
    }
}