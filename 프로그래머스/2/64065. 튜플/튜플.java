import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] set = s.split("},");
        for(int i = 0; i < set.length; i++){
            set[i] = set[i].replaceAll("\\{","").replaceAll("\\}","");
        }
        
        Arrays.sort(set,(a,b) -> a.length() - b.length());
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(String str : set){
            String[] numbers = str.split(",");
            for(String strNum : numbers){
                int num = Integer.parseInt(strNum);
                if(!arr.contains(num)) arr.add(num);
            }
        }
        
        int[] result = new int[arr.size()];        
        for(int i = 0; i < arr.size(); i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
}