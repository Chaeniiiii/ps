import java.util.*;

class Solution {
    
    private int st;
    
    private class Assign{
        
        String name;
        int st;
        int div;
        
        private Assign(String name, int st, int div){
            this.name = name;
            this.st = st;
            this.div = div;
        }
        
        private void updateT(int div){
            this.div -= div;
        }
        
            
    }
    
    public String[] solution(String[][] plans) {
        
        ArrayList<Assign> arr = new ArrayList<>();
        for(int i = 0 ; i < plans.length; i++){
            String[] plan = plans[i];
            int time = calcT(plan[1]);
            arr.add(new Assign(plan[0],time,Integer.parseInt(plan[2])));
        }
        
        arr.sort((a,b) -> a.st - b.st);
        
        String[] result = new String[plans.length];
        Deque<Assign> deque = new ArrayDeque<>();
        int idx = 0;
        
        for(int i = 0; i < arr.size() - 1; i++){
            
            Assign now = arr.get(i);
            Assign nxt = arr.get(i+1);
            
            int nowT = now.div;
            int t = nxt.st - now.st;
            
            if(nowT <= t){
                t -= nowT;
                result[idx++] = now.name;
                
                while(t > 0 && !deque.isEmpty()){
                    
                    Assign wait = deque.pollLast();
                    if(wait.div <= t){
                        t -= wait.div;
                        result[idx++] = wait.name;
                    }
                    else{
                        wait.updateT(t);
                        t = 0;
                        deque.add(wait);
                    }
                }
            }
            else{
                now.updateT(t);
                deque.add(now);
            }
            
        }

        result[idx++] = arr.get(arr.size() - 1).name;
        while(!deque.isEmpty()){
            result[idx++] = deque.pollLast().name;
        }
        
        return result;
        
        
        
    }
    
    private int calcT(String time){
        
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0])*60;
        int m = Integer.parseInt(t[1]);
        
        return h + m;
        
    }
}