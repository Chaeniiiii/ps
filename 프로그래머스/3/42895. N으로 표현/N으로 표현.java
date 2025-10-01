import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        ArrayList<Set<Integer>> map = new ArrayList<>();
        String strNum = String.valueOf(N);
        
        for(int i = 0; i <= 8; i++){
            map.add(new HashSet<>());
            if(i == 0) continue;
            int originR = Integer.valueOf(strNum.repeat(i));
            if(originR == number) return i;
            map.get(i).add(originR);
        }
        
        for(int i = 2; i <= 8; i++){
            
            for(int j = 1; j <= i; j++){
                for(int num : map.get(j)){
                    for(int prevNum : map.get(i - j)){
                        int a = num + prevNum;
                        int b = num - prevNum;
                        int c = num * prevNum;
                        if(prevNum != 0){
                            int d = num / prevNum;
                            if(d == number) return i;
                            map.get(i).add(d);
                        }
                        
                        if(a == number || b == number || c == number ) return i;
                        map.get(i).add(a);
                        map.get(i).add(b);
                        map.get(i).add(c);
                        
                    }
                }
            }
        }
        
        return -1;
        
    }
}