import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        int len = cards.length;
        boolean[] visited = new boolean[len];
        
        ArrayList<Integer> number = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++){
            if(visited[i]) continue; 
            
            int k = i, cnt = 0;
            while(!visited[k]){
                cnt++;
                visited[k] = true;
                k = cards[k] - 1;
            }
            
            number.add(cnt);
            
        }
        
        if(number.size() == 1) return 0;
        number.sort((a,b) -> b - a);
        
        return number.get(0) * number.get(1);
        
    }
}