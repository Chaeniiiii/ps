import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String,Integer> pch = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        
        int cnt = 0;
        for(int i = 0; i < want.length; i++){
            pch.put(want[i],number[i]);
            cnt+=number[i];
        }
        if(cnt > discount.length) return 0;
        
        for(int i = 0; i < Math.min(10,discount.length); i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
        }
        
        int lt = 0, rt = Math.min(10,discount.length)-1, result = 0;
        while(rt < discount.length){
            
            boolean check = true;
            for(String key : pch.keySet()){
                if(!map.containsKey(key) || map.get(key) < pch.get(key)){
                    check = false;
                    break;
                }
            }
            
            if(check){
                result++;
            }
            
            map.put(discount[lt],map.get(discount[lt])-1);
            if(map.get(discount[lt]) == 0) map.remove(discount[lt]);
            lt++;
            rt++;
            if(rt < discount.length) map.put(discount[rt],map.getOrDefault(discount[rt],0)+1);
            
            
        }
        
        return result;
        
        
    }
}