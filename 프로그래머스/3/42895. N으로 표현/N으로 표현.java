import java.util.*;

class Solution {
    
    private static final int LIMIT = 8;
    
    public int solution(int N, int number) {
        
        if(number == N) return 1;
        
        List<Set<Integer>> arr = new ArrayList<>();
        
        for(int i = 0 ; i <= LIMIT; i++){
            arr.add(new HashSet<>());
        }
        
        arr.get(1).add(N);
        
        for(int i = 2; i <= LIMIT; i++){
            
            Set<Integer> set = arr.get(i);
            
            int rep = Integer.parseInt(String.valueOf(N).repeat(i));
            if(rep == number) return i;
            
            set.add(rep);
            
            for(int j = 1; j < i; j++){
                for(int now : arr.get(j)){
                    for(int prev : arr.get(i-j)){
                        int a = now + prev;
                        int b = now - prev;
                        int c = now * prev;
                        if(prev != 0){
                            int d = now / prev;
                            if(d == number) return i;
                            else set.add(d);
                        }
                        
                        if(a == number || b == number || c == number) return i;
                        
                        set.add(a);
                        set.add(b);
                        set.add(c);
                    }
                }
            }
        }
        
        return -1;
        
    }
}