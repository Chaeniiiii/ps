import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book,(a,b) -> a.length()-b.length());
        
        Set<String> set = new HashSet<>();
        for(String str : phone_book){
            String s = "";
            for(char c : str.toCharArray()){
                s+=c;
                if(set.contains(s)) return false;
            }
            set.add(s);
        }
        
        return true;
        
    }
}