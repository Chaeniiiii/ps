import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String,Integer> map = init();
        
        ArrayList<Integer> arr = new ArrayList<>();
        int seq = 27, i = 0;

        while(i < msg.length()){
            
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            i++;
                
            while(i < msg.length() && map.containsKey(sb.toString() + msg.charAt(i))){
                sb.append(msg.charAt(i));
                i++;
            }
            
            arr.add(map.get(sb.toString()));
            
            if(i < msg.length()){
                map.put(sb.toString() + msg.charAt(i) , seq);
                seq++;
            }
        }
        
        int[] result = new int[arr.size()];
        for(int k = 0; k < arr.size(); k++){
            result[k] = arr.get(k);
        }
        
        return result;
        
    }
    
    private static Map<String,Integer> init(){
        
        Map<String,Integer> map = new HashMap<>();
        
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), c-'A'+1);
        }
        
        return map;
        
    }
    
}