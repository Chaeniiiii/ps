import java.util.*;

class Solution {
    
    private static Map<String,Integer> map;
    
    public int[] solution(String msg) {
        
        map = new HashMap<>();
        init();
    
        StringBuilder sb;
        ArrayList<Integer> arr = new ArrayList<>();
        
        int pt = 0, idx = 27;
        
        while(pt < msg.length()){
            
            sb = new StringBuilder();
            sb.append(msg.charAt(pt));
            pt++;
            
            while(pt < msg.length() && map.containsKey(sb.toString()+ msg.charAt(pt))){
                
                sb.append(msg.charAt(pt));
                pt++;
                
            }
            
            String str = sb.toString();
            arr.add(map.get(str));
            
            if(pt < msg.length()){
                map.put(str+msg.charAt(pt),idx);
                idx++;    
            }
            
            
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0 ; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
    
    private static void init(){
        
        char c = 'A';
        
        for(int i = 1; i <= 26; i++){
            map.put(String.valueOf(c),i);
            c++;
        }
        
    }
    
}