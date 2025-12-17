import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 1; i < phone_book.length; i++){
            String now = phone_book[i];
            String prev = phone_book[i-1];
            if(now.startsWith(prev)) return false;
        }
        return true;
    }
}