import java.util.*;

class Solution { 
    public int solution(int cacheSize, String[] cities) {
        
        ArrayList<String> arr = new ArrayList<>();
        
        if(cacheSize == 0) return cities.length * 5;
        
        int time = 0;
        for(String str : cities){
            
            str = str.toUpperCase();
            int idx = arr.indexOf(str);
            
            if(idx == -1){
                if(arr.size() == cacheSize) arr.remove(0);
                arr.add(str);
                time+=5;
            }
            else{
                arr.remove(idx);
                arr.add(str);
                time+=1;
            }
        }
        
        return time;
    }
}