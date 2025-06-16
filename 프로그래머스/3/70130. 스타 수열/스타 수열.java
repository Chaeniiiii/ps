import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        int result = 0;
        for(int key : map.keySet()){
            
            if(map.get(key) <= result) continue;
            
            int cnt = 0;
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] != key && arr[i+1] != key) continue;
                if(arr[i] == arr[i+1]) continue;
                
                cnt ++;
                i++;
                
            }
            
            result = Math.max(cnt,result);
            
        }
        
        return result*2;
        
    }
}