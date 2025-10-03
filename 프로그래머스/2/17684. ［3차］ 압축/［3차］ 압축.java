import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String,Integer> map = init();
        int dictSize = 27;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int idx = 0;
        while(idx < msg.length()){
            
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(idx));
            
            int nxt = idx + 1;
            
            while(nxt < msg.length() && map.containsKey(sb.toString() + msg.charAt(nxt))){
                sb.append(msg.charAt(nxt));
                nxt++;
            }
            
            arr.add(map.get(sb.toString()));
            
            if(nxt < msg.length()){
                
                sb.append(msg.charAt(nxt));
                map.put(sb.toString(),dictSize);
                dictSize++;
                
            }
            
            idx = nxt;
            
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
    
    private static Map<String, Integer> init(){
        
        Map<String,Integer> map = new HashMap<>();
        
        int num = 1;
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c),num);
            num++;
        }
        
        return map;
        
    }
}