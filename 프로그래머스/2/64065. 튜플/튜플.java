import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] tuple = s.split("},");
        Map<Integer,Integer> map = new HashMap<>();
        
        for(String str : tuple){
            
            str = str.replace("{","").replace("}","");
            String[] newStr = str.split(",");
            
            for(int i = 0; i < newStr.length; i++){
                int num = Integer.parseInt(newStr[i]);
                map.put(num,map.getOrDefault(num,0)+1);
            }
            
        }
        
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a,b) -> map.get(b) - map.get(a));
        
        int[] result = new int[keySet.size()];
        for(int i = 0; i < keySet.size(); i++){
            result[i] = keySet.get(i);
        }
        
        return result;
        
    }
}