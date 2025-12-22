import java.util.*;

class Solution {
    
    private static final int NUM = 65536;
    
    public int solution(String str1, String str2) {
        
        Map<String,Integer> map1 = getStr(str1.toUpperCase());
        Map<String,Integer> map2 = getStr(str2.toUpperCase());
        
        //합집합 찾기
        int union = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)) union += Math.max(map1.get(key),map2.get(key));
            else union += map1.get(key);
        }
        for(String key : map2.keySet()){
            if(map1.containsKey(key)) continue;
            else union += map2.get(key);
        }

        //교집합 찾기
        int sec = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)) sec+= Math.min(map1.get(key),map2.get(key));
        }
        
        if(union == 0) return NUM;
        return (int)(((double)sec/union) * NUM);
        
    }
    
    private static Map<String,Integer> getStr(String str){
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length() - 1; i++){
            String newStr = str.substring(i,Math.min(str.length(),i+2)).replaceAll("[^A-Z]","");
            if(newStr.length() != 2) continue;
            map.put(newStr,map.getOrDefault(newStr,0)+1);
        }
        
        return map;
        
    }
}