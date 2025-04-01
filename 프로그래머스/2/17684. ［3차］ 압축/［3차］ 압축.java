import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        Map<String,Integer> map = init();
        Deque<String> deque = new ArrayDeque<>();
        
        for(char c : msg.toCharArray()) deque.add(String.valueOf(c));
        StringBuilder now = new StringBuilder();
        while(!deque.isEmpty()){
        
            now.append(deque.poll());
            
            boolean check = false;
            while(map.containsKey(now.toString())){
                if(deque.isEmpty()) {
                    check = true;
                    break;
                }
                now.append(deque.poll());
            }
            
            String str = now.toString();
            
            if(check){
                arr.add(map.get(str));
                continue;
            }
            
            map.put(str,map.size()+1);
            arr.add(map.get(str.substring(0,str.length()-1)));
            
            now = new StringBuilder();
            now.append(str.charAt(str.length()-1));
                            
            if(deque.isEmpty()) arr.add(map.get(now.toString()));
            
        }        
        
        int [] result = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++) result[i] = arr.get(i);
        
        return result;
    }
    
    private static Map<String,Integer> init(){
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(char c = 'A'; c<='Z'; c++){
            map.put(String.valueOf(c),(int)(c-'A')+1);
        }
        
        return map;
        
    }
}