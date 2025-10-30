import java.util.*;

class Solution {
    
    private static int[] fees;
    
    //차량의 입출차 시간 기록
    private static class Car{
        
        PriorityQueue<Integer> st;
        PriorityQueue<Integer> en;
        
        private Car(){
            this.st = new PriorityQueue<>();
            this.en = new PriorityQueue<>();
        }
        
        
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        this.fees = fees;
        
        Map<String,Car> map = new TreeMap<>();
        for(int i = 0; i < records.length; i++){
            
            String[] rcd = records[i].replaceAll(":"," ").split(" ");
            
            int h = Integer.parseInt(rcd[0]) * 60;
            int m = Integer.parseInt(rcd[1]);
            
            String number = rcd[2];
            String action = rcd[3];

            Car car = map.containsKey(number) ? map.get(number) : new Car();
            
            switch(action){
                case "IN" :
                    car.st.add(h+m);
                    break;
                case "OUT" : 
                    car.en.add(h+m);
                    break;
            }
            
            map.put(number,car);
            
        }
        
        int[] result = new int[map.size()];

        int i = 0;
        for(String key : map.keySet()){
            
            Car car = map.get(key);
            int odd = car.st.size() - car.en.size();
            while(odd-- > 0){
                car.en.add(1439);
            }
            
            int size = car.st.size();
            int cnt = 0;
            while(size-- > 0){
                cnt += calc(car);
            }
            
            result[i] = calc2(cnt);
            i++;
            
        }
        
        return result;

    }
    
    private static int calc(Car car){
        
        int stT = car.st.poll();
        int enT = car.en.poll();
        
        int time = enT - stT;
        return time;
        
    }
    
    private static int calc2(int time){
        
        if(time <= fees[0]) return fees[1];
        
        time -= fees[0];
        return fees[1] + (time / fees[2] * fees[3]) + (time % fees[2] == 0 ? 0 : fees[3]);
         
    }
    
}