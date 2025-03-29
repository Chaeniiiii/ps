import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Map<Integer,Integer> map = new LinkedHashMap<>();
        String [] str = s.replace("{","").split("},");
        
        for(String numArr : str){
            String [] numStr = numArr.replace("}","").split(",");
            for(String ss : numStr){
                int num = Integer.parseInt(ss);
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        
        ArrayList<int []> arr = new ArrayList<>();
        int [] result = new int[map.size()];
        
//         for(int key : map.keySet()){
//             System.out.printf("%d %d\n",key,map.get(key));
//         }
            
        
        for(int key : map.keySet()) arr.add(new int[]{key,map.get(key)});
        arr.sort((a,b) -> b[1] - a[1]);
        
        for(int i = 0 ; i<arr.size(); i++) result[i] = arr.get(i)[0];
        
        return result;
        
    }
}