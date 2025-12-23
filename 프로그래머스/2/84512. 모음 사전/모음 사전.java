import java.util.*;

class Solution {
    public int solution(String word) {
        
        int[] num = new int[]{781,156,31,6,1};
        Map<Character,Integer> map = init();
        
        int cnt = 0;
        for(int i = word.length() - 1; i >= 0; i--){
            
            cnt += map.get(word.charAt(i)) * num[i] + 1;
            
        }
        
        return cnt;
        
    }
    
    private static Map<Character,Integer> init(){
        
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('E',1);
        map.put('I',2);
        map.put('O',3);
        map.put('U',4);
        
        return map;
        
    }
    
}