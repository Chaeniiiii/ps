import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        ArrayList<Set<Long>> arr = new ArrayList<>();
        arr.add(new HashSet<>());
        arr.get(0).add((long)N);
        
        String s = String.valueOf(N);
        
        for(int i = 1; i <= 8; i++){
            
            arr.add(new HashSet<>());
            int lt = 0, rt = i - 1;
            while(rt >= 0){
                for(long now : arr.get(lt)){
                    for(long nxt : arr.get(rt)){
                        if(nxt == number) return i;
                        if(isPossible(now + nxt)) arr.get(i).add(now + nxt);
                        if(isPossible(now - nxt)) arr.get(i).add(now - nxt);
                        if(isPossible(now / nxt)) arr.get(i).add(now / nxt);
                        if(isPossible(now * nxt)) arr.get(i).add(now * nxt);
                    }
                }
                
                lt++;
                rt--;
                arr.get(i).add(Long.parseLong(s.repeat(i+1)));
                
            }
            
        }
        
        return -1;
        
    }
    
    private boolean isPossible(long num){
        return num == 0 ? false : true;
    }
    
}