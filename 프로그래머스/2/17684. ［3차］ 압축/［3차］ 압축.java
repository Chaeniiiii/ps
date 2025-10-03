import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String,Integer> map = init();
        int number = 27;
        
        int lt = 0, rt = 0;
        boolean check = false;
        ArrayList<Integer> arr = new ArrayList<>();
        while(lt <= rt && lt < msg.length()){
            
            String str = msg.substring(lt,rt+1);
            while(map.containsKey(str)){
                rt++;
                if(rt >= msg.length()){
                    arr.add(map.get(str.substring(0,str.length())));
                    check = true;
                    break;
                }
                str += msg.charAt(rt);
            }
            
            if(check) break;
            
            map.put(str,number);
            number++;
            
            arr.add(map.get(str.substring(0,str.length()-1)));
            
            lt = rt;
            rt = lt;
            
        }
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
    
    private static Map<String,Integer> init(){
        
        Map<String,Integer> map = new HashMap<>();
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), idx);
            idx++;
        }
        
        return map;
        
    }
}
