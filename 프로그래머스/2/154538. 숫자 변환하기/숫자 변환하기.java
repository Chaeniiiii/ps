import java.util.*;

class Solution {
    
    private static final int MAX = 1000001;
    
    public int solution(int x, int y, int n) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);
        
        boolean [] visited = new boolean[MAX];
        
        int cnt = 0;
        while(!deque.isEmpty()){
        
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                int num = deque.poll();
                if(num == y) return cnt; 
                
                for(int next : new int []{num*2,num*3,num+n}){
                    if(next > y || visited[next] ) continue;
                    visited[next] = true;
                    deque.add(next);
                }
                
            }
            
            cnt ++;
            
        }
        
        return -1;
        
    }
}