import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String,Integer> map = new HashMap<>();
        map.put(phone_book[0],1);
        
        Arrays.sort(phone_book);
        
        for(int i = 1; i<phone_book.length; i++){
            
            String prev = phone_book[i-1];
            String now = phone_book[i];
            
            if(now.length() < prev.length()) continue;
            if(now.substring(0,prev.length()).equals(prev)) return false;
            
            map.put(now,map.getOrDefault(now,0)+1);
            
        }
        
        return true;
        
    }
}