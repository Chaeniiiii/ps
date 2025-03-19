import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
    
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        map1 = setMap(str1,map1);
        map2 = setMap(str2,map2);

        int itsec = 0;
        int union = 0;
       
        for(String key : map1.keySet()){
            
            if(map2.get(key) != null){
                itsec+=Math.min(map1.get(key),map2.get(key));
                union+=Math.max(map1.get(key),map2.get(key));
            }
            else{
                union+=map1.get(key);
            }
            
        }
        
        for(String key : map2.keySet()){
            if(map1.get(key) == null) union+=map2.get(key);
        }
        
        if(itsec == 0 && union == 0 ) return 65536;
        return (int) (((double) itsec / union) * 65536);
        
    }
    
    private static Map<String,Integer> setMap(String str,Map<String,Integer> map){
        for(int i = 0; i<str.length()-1; i++){
            String s = str.substring(i,i+2).toUpperCase();
            if(!s.matches("[A-Z]+")) continue;
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        return map;
    }
    
   
}