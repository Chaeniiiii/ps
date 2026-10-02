import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            String now = phone_book[i];
            String nxt = phone_book[i+1];
            if(nxt.startsWith(now)) return false;
        }
        
        return true;
        
    }
}