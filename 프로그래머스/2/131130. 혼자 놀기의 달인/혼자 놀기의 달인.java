import java.util.*;

class Solution {
    
    public int solution(int[] cards) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque;
        
        boolean[] visited = new boolean[cards.length+1];
        
        int num = 0; //확인한 카드 개수
        for(int i = 0; i < cards.length; i++){
            
            if(visited[i]) continue;
            
            int cnt = 0; //현재까지 확인한 카드 개수 
            
            deque = new ArrayDeque<>();
            deque.add(i);
            
            while(!deque.isEmpty()){
                
                int idx = deque.poll();
                
                if(visited[idx]) break;
                visited[idx] = true;
                deque.add(cards[idx] - 1);
                cnt++;
               
            }
            
            result.add(cnt);
            
        }
        
        if(result.size() <= 1) return 0;
        result.sort((a,b) -> b - a);
        
        return result.get(0) * result.get(1);
        
    }
    
}

