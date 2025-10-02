import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0) return cities.length * 5;

        ArrayList<String> cache = new ArrayList<>();
        int time = 0;

        for(String city : cities) {
            city = city.toLowerCase(); 

            if(cache.remove(city)) { 
                time += 1;
            } else {
                time += 5;
                if(cache.size() == cacheSize) {
                    cache.remove(0);
                }
            }
            cache.add(city); 
        }

        return time;
    }
}
