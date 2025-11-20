import java.util.*;

class Solution {
    
    private static class Topping{
        
        int cnt; //토핑 개수
        int idx; //토핑의 첫 등장 인덱스
        
        private Topping(int cnt, int idx){
            this.cnt = cnt;
            this.idx = idx;
        }
    }
    
    public int solution(int[] topping) {
        
        Map<Integer,Topping> map = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++){
            int tp = topping[i];
            if(map.containsKey(tp)){
                map.get(tp).cnt++;
            }
            else{
                map.put(tp, new Topping(1,i));
            }
        }
        
        int[] cut = new int[2];
        cut[1] = map.keySet().size();
        
        int result = 0;
        for(int i = 0; i < topping.length; i++){
            
            int nowTp = topping[i];
            if(map.get(nowTp).idx == i) cut[0]++;
            map.get(nowTp).cnt--;
            
            if(map.get(nowTp).cnt <= 0) cut[1]--;
            if(cut[0] == cut[1]) result++;
                        
        }
        
        return result;
        
        
    }
}