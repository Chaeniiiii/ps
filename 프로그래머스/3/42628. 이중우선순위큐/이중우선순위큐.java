import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minNum = new PriorityQueue<>();
        PriorityQueue<Integer> maxNum = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i = 0; i < operations.length; i++){
            String[] op = operations[i].split(" ");
            int num = Integer.parseInt(op[1]);
                
            switch(op[0]){
                case "I":
                    minNum.add(num);
                    maxNum.add(num);
                    break;
                case "D":
                    if(maxNum.peek() == minNum.peek()){
                        minNum.remove(maxNum.poll());
                        maxNum.remove(minNum.poll());
                        continue;
                    }
                    if(num == 1){
                        minNum.remove(maxNum.poll());
                    }
                    else{
                       maxNum.remove(minNum.poll());
                    }
                    break;
            }
        }
        
        int[] result = new int[2];
        if(!maxNum.isEmpty()) result[0] = maxNum.poll();
        if(!minNum.isEmpty()) result[1] = minNum.poll();
        
        return result;
        
    }
}