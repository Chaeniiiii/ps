import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int n = cities.length;
        if(cacheSize == 0) return n * 5;
        
        int cnt = 0;
        List<String> list = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            String now = cities[i].toLowerCase();
            
            if(list.size() == 0){
                cnt += 5;
                list.add(now);
                continue;
            }
            
            if(list.size() == cacheSize){
                if(list.contains(now)){
                    list.remove(now);
                    list.add(now);
                    cnt++;
                }
                else{
                    list.remove(list.get(0));
                    list.add(now);
                    cnt+=5;
                }
            }
            else{
                if(list.contains(now)){
                    list.remove(now);
                    list.add(now);
                    cnt++;
                }
                else{
                    list.add(now);
                    cnt+=5;
                }
            }
        }
        
        return cnt;
        
        
    }
}