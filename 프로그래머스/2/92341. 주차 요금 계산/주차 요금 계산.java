import java.util.*;

class Solution {
    
    private static final int MAX = 1439;
    
    private static class Car{
        
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        
        private Car(int inT){
            in.add(inT);
            out.add(MAX);
        }
        
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        Set<String> carN = new TreeSet<>();
        Map<String,Car> map = new HashMap<>();
        
        for(String record : records){
            
            String[] r = record.split(" ");
            
            String carNum = r[1]; //차량 번호
            int time = getT(r[0]); //입출차 시간 
            
            switch(r[2]){
                case "IN":
                    if(map.containsKey(carNum)){
                        map.get(carNum).in.add(time);
                        map.get(carNum).out.add(MAX);
                    }
                    else{
                        map.put(carNum,new Car(time));
                    }
                    break;
                case "OUT":
                    ArrayList<Integer> carOut = map.get(carNum).out;
                    carOut.set(carOut.size() - 1, time);
                    break;
            }
            
            carN.add(carNum);
            
        }
        
        int[] result = new int[carN.size()];
        int idx = 0;
        
        for(String num : carN){
            Car car = map.get(num);
            int price = 0, total = 0;
            
            for(int i = 0; i < car.in.size(); i++){
                int inT = car.in.get(i);
                int outT = car.out.get(i);
                total += outT - inT;
                
            }
            if(total >= fees[0]){
                price+=fees[1];
                total-= fees[0];
                price += (total / fees[2]) * fees[3] + (total % fees[2] == 0 ? 0 : fees[3]);
            }
            else{
                price+=fees[1];
            }
            result[idx] = price;
            idx++;
        }
        
        return result;
        
    }
    
    private static int getT(String t){
        
        String[] time = t.split(":");
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            
    }
    
}