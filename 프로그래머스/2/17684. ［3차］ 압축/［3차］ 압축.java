import java.util.*;

class Solution {
    
    private static Map<String,Integer> map;
    
    public int[] solution(String msg) {
        
        map = new HashMap<>();
        init();
    
        StringBuilder sb;
        ArrayList<Integer> arr = new ArrayList<>();
        
        int lt = 0, rt = lt + 1, idx = 27;
        
        while(lt < rt){
            
            sb = new StringBuilder();
            sb.append(msg.charAt(lt));
            
            while(rt < msg.length() && map.containsKey(sb.toString()+ msg.charAt(rt))){
                
                sb.append(msg.charAt(rt));
                rt++;
                
            }
            
            String str = sb.toString();
            arr.add(map.get(str));
            
            if(rt < msg.length()){
                map.put(str+msg.charAt(rt),idx);
                idx++;    
            }
            
            lt = rt;
            rt = Math.min(msg.length(),lt+1);
            
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