import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(String operate : operations){
            
            String [] cmd = operate.split(" ");
            char c = cmd[0].charAt(0);
            int num = Integer.parseInt(cmd[1]);
            
            if(c == 'I'){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            else{
                if(map.isEmpty()) continue;
                if(num == 1){
                    int key = map.lastEntry().getKey();
                    if(map.get(key) <= 1) map.remove(key);
                    else map.put(key,map.get(key)-1);
                }
                else{
                   int key = map.firstEntry().getKey();
                    if(map.get(key) <= 1) map.remove(key);
                    else map.put(key,map.get(key)-1);
                }
            }
        }
        
        if(map.size() == 0) return new int[]{0,0};
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int key : map.keySet()){
            min = Math.min(min,key);
            max = Math.max(max,key);
        }
        
        return new int[]{max,min};
        
    }
}