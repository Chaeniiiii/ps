import java.util.*;

class Solution {
    public int solution(String word) {
        int[] weight = {781, 156, 31, 6, 1};
        Map<Character,Integer> map = init();
        
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            answer += map.get(word.charAt(i)) * weight[i] + 1;
        }
        
        return answer;
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
