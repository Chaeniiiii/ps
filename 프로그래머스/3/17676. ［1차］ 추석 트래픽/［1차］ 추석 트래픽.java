import java.util.*;

class Solution {
    
    private static class Task{
        
        int st;
        int en;
        
        private Task(int st, int en){
            this.st = st;
            this.en = en;
        }  
    }
    
    public int solution(String[] lines) {
        
        ArrayList<Task> arr = new ArrayList<>();
        
        for(String line : lines){
            
            String[] taskT = line.split(" ");
            String[] en = taskT[1].split(":");
            
            double s = Double.parseDouble(en[2]) - Double.parseDouble(taskT[2].replace("s",""));
            
            String[] st = en.clone();
            st[2] = String.valueOf(s);
            
            int stT = convert(st) + 1;
            int enT = convert(en);
            
            Task task = new Task(stT,enT);
            arr.add(task);        
            
        }
        
        int result = 0;
        for(int i = 0; i < arr.size(); i++){
            int cnt = 0;
            Task now = arr.get(i);
            for(int j = i; j < arr.size(); j ++){
                Task nxt = arr.get(j);
                if(now.en + 1000 - 1 < nxt.st) continue;
                cnt++;
            }
            result = Math.max(result,cnt);
        }
        
        return result;
        
    }
    
    private static int convert(String[] time){
        
        int h = Integer.parseInt(time[0])* 1000;
        int m = Integer.parseInt(time[1]) * 1000;
        int s = (int)(Double.parseDouble(time[2]) * 1000.0);
        
        return h*3600 + m*60 + s;
        
    }
    
}