import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < operations.length; i++){
            
            String[] op = operations[i].split(" ");
            String cmd = op[0];
            
            int n = Integer.parseInt(op[1]);
            
            if(cmd.equals("I")){
                map.put(n,map.getOrDefault(n,0)+1);
                max.add(n);
                min.add(n);
            }
            else{
                PriorityQueue<Integer> now = n == 1 ? max : min;
                if(now.isEmpty()) continue;
                
                int number = now.poll();
                while(map.get(number) <= 0 && !now.isEmpty()){
                    number = now.poll();
                }
                map.put(number,map.get(number) - 1);
            }
        }
        
        int[] result = new int[2];
        while(!max.isEmpty()){
            int num = max.poll();
            if(map.get(num) > 0){
                result[0] = num;
                break;
            }
        }
        
        while(!min.isEmpty()){
            int num = min.poll();
            if(map.get(num) > 0){
                result[1] = num;
                break;
            }
        }
        
        return result;
        
    }
}