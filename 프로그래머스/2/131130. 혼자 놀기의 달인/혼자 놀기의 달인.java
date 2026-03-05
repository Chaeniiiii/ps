import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int len = cards.length;
        
        boolean[] visited = new boolean[len];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            
            int cnt = 0;
            int idx = i;
            
            while(!visited[idx]){
                cnt++;
                visited[idx] = true;
                idx = cards[idx] - 1;
            }
            
            arr.add(cnt);
            
        }
        
        arr.sort((a,b) -> b- a);
        return arr.size() < 2 ? 0 : arr.get(0) * arr.get(1);
        
    }
}