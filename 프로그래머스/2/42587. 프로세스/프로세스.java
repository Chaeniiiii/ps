import java.util.*;

class Solution {
    
    private static class Process {
        
        int num;
        int priority;
        
        private Process(int num, int priority){
            this.num = num;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Process> deque = new ArrayDeque<>();
        
        for(int i = 0; i<priorities.length; i++){
            deque.add(new Process(i,priorities[i]));
            arr.add(priorities[i]);
        }
        
        arr.sort((a,b) -> b-a);
        
        int idx = 0;
        int seq = 1;

        while(!deque.isEmpty()){
            if(idx >= priorities.length) break;
            
            Process process = deque.poll();
           
            if(process.priority == arr.get(idx)){
                if(process.num == location) return seq;
                else idx ++;
                seq ++;
            }
            else {
                deque.add(process);
            }
        }
        
        return seq;
        
    }
}