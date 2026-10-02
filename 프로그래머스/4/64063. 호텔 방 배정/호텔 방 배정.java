import java.util.*;

class Solution {
    
    private Map<Long,Long> map;
    
    public long[] solution(long k, long[] room_number) {
        
        map = new HashMap<>();
        long[] result = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++){
            result[i] = findRoom(room_number[i]);
        }
        
        return result;
        
    }
    
    private long findRoom(long room){
        
        long parent = map.getOrDefault(room,0L);
        
        if(parent == 0){
            map.put(room,room+1);
            return room;
        }
             
        long nxt = findRoom(parent);
        map.put(room,nxt+1);
        return nxt;
        
    }
    
}