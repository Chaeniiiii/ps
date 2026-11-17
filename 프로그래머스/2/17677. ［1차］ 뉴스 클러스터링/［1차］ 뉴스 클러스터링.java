import java.util.*;

class Solution {
    
    private final int NUM = 65536;
    
    public int solution(String str1, String str2) {
        
        Map<String,Integer> map1 = makeStr(str1);
        Map<String,Integer> map2 = makeStr(str2);
        
        //교집합
        int a = 0;
        for(String key : map1.keySet()){
            if(!map2.containsKey(key)) continue;
            a += Math.min(map2.get(key),map1.get(key));
        }
        
        
        //합집합
        int b = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                b += Math.max(map2.get(key),map1.get(key));
            }
            else{
                b += map1.get(key);
            }
        }
        
        for(String key : map2.keySet()){
            if(map1.containsKey(key)) continue;
            b += map2.get(key);
        }
        
        if(b == 0) return NUM;
        
        return (int)(((double)a / (double)b) * NUM) ;
        
    }
    
    private Map<String,Integer> makeStr(String str){
        
        Map<String,Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        
        for(int i = 1; i < str.length(); i++){
            sb.append(str.charAt(i));
            String s = sb.toString();
            
            boolean isAlphabet = s.matches("^[a-zA-Z]+$");
            if(isAlphabet){
                 s = s.toUpperCase();
                 map.put(s,map.getOrDefault(s,0)+1); 
            }
            sb.deleteCharAt(0);
        }
        
        return map;
        
    }
}