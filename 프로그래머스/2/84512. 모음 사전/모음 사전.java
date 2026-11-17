import java.util.*;

class Solution {
    public int solution(String word) {
        
        int[] idx = new int[]{781, 156, 31, 6, 1};
        Map<Character, Integer> map = init();
        
        int result = 0;
        for(int i = 0; i < word.length(); i++){
            
            char c = word.charAt(i);
            result += (idx[i] * map.get(c)) + 1;
            
        }
        
        return result;
        
    }
    
    private Map<Character,Integer> init(){
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('E',1);
        map.put('I',2);
        map.put('O',3);
        map.put('U',4);
        
        return map;
        
    }
}