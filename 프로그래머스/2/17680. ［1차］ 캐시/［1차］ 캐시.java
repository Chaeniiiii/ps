import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0) return cities.length * 5;
        
        ArrayList<String> arr = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            if(arr.contains(city)){
                cnt++;
                arr.remove(arr.indexOf(city));
            }
            else{
                cnt+=5;
                if(arr.size() == cacheSize) arr.remove(0);
            }
            arr.add(city);
        }
        
        return cnt;
        
    }
}