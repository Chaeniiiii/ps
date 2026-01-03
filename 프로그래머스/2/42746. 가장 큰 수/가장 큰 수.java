import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        int n = numbers.length;
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        
        for(int i = 0; i < n; i++){
            String str = String.valueOf(numbers[i]);
            int num = str.charAt(0) - '0';
            
            map.computeIfAbsent(num,v -> new ArrayList<>()).add(numbers[i]);
        }
        
        for(int key : map.keySet()){
            ArrayList<Integer> arr = map.get(key);
            arr.sort((a,b) -> {
                String aStr = String.valueOf(a);
                String bStr = String.valueOf(b);
                
                int aLen = aStr.length();
                int bLen = bStr.length();
                
                if(aLen > bLen){
                    if(aStr.charAt(bLen) > bStr.charAt(bLen - 1)) return b - a;
                }
                else if(aLen < bLen){
                    if(bStr.charAt(aLen) > aStr.charAt(aLen - 1)) return a - b;
                }
                else{
                    if(aStr.charAt(aLen - 1) > bStr.charAt(aLen - 1)) return b - a;
                    else return a - b;
                }
                
                return a - b;
            });
        }
        
        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        StringBuilder sb = new StringBuilder();
        
        for(int i = key.size() - 1; i >= 0; i--){
            ArrayList<Integer> arr = map.get(key.get(i));
            for(int j = 0 ; j < arr.size(); j++){
                sb.append(arr.get(j));
            }
        }

        return sb.toString().charAt(0) == '0' ? "0" : sb.toString(); 
        
    }
}