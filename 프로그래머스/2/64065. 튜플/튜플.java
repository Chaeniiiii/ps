import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] t = s.split("},");
        for(int i = 0; i < t.length; i++){
            t[i] = t[i].replace("{","").replace("}","");
        }
        Arrays.sort(t,(a,b) -> a.length() - b.length());
        
        ArrayList<Integer> arr = new ArrayList<>();        
        
        for(String str : t){
            
            String newStr = str;
            String[] number = newStr.split(",");
            
            for(int i = 0; i < number.length; i++){
                int num = Integer.parseInt(number[i]);
                if(!arr.contains(num)){
                    arr.add(num);
                }
            }
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
    
        return result;
        
    }
}