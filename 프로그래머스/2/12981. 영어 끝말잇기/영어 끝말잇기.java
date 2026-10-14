import java.util.*;

class Solution {
    
    public int[] solution(int n, String[] words) {

        char prev = words[0].charAt(words[0].length() - 1);
        
        Map<String,Integer> map = new HashMap<>();
        map.put(words[0],1);
        
        for(int i = 1; i < words.length; i++){
            
            String word = words[i];
            if(map.getOrDefault(word,0) != 0 || prev != word.charAt(0)){
                return new int[]{i % n + 1, i / n + 1};
            }
            map.put(word,map.getOrDefault(word,0)+1);
            prev = word.charAt(word.length() - 1);
        }
        
        return new int[]{0,0};
        
    }
}