import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(1,s.length() - 2);
        s = s.replace("{","");
        
        String[] tuple = s.split("},");
        Arrays.sort(tuple,(a,b) -> a.length() - b.length());
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < tuple.length; i++){
            String[] now = tuple[i].split(",");
            for(int j = 0; j < now.length ; j++){
                int n = Integer.parseInt(now[j]);
                if(!arr.contains(n)) arr.add(n);
            }
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
}