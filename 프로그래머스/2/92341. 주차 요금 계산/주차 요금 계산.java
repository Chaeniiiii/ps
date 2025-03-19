import java.util.*;

class Solution {
    
    private static Fee fee;
    
    private static class Fee {
        
        int basicT;
        int basicP;
        
        int unitT;
        int unitP;
        
        private Fee(int [] fees){
            this.basicT = fees[0];
            this.basicP = fees[1];
            this.unitT = fees[2];
            this.unitP = fees[3];
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
    
        Map<String,ArrayList<String>> in = new TreeMap<>();
        Map<String,ArrayList<String>> out = new TreeMap<>();
        
        fee = new Fee(fees);
        
        for(String s : records){
            String [] str = s.split(" ");
            
            if(str[2].equals("IN")) {
                in.computeIfAbsent(str[1],v-> new ArrayList<>()).add(str[0]);
            }
            else {
                out.computeIfAbsent(str[1],v-> new ArrayList<>()).add(str[0]);
            }
            
        }
        
        int idx = 0;
        int [] result = new int[in.size()];
        
        for(String key : in.keySet()){
        
            int total = 0;
            for(int i = 0; i<in.get(key).size(); i++){
                if(out.get(key) == null || out.get(key).size() <= i){
                    total += getTime(in.get(key).get(i),"23:59");
                }
                else{
                    total += getTime(in.get(key).get(i),out.get(key).get(i));
                }
            }
            
            result[idx] = getPrice(total);
            idx ++;
            
        }
        
        
        return result;
        
    }
    
    private static int getTime(String str1, String str2){
        
        String [] a = str1.split(":");
        String [] b = str2.split(":");
        
        int aTime = 0;
        int bTime = 0;
        
        aTime = (Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]));
        bTime = (Integer.parseInt(b[0])*60 + Integer.parseInt(b[1]));
        
        return bTime - aTime;
        
    }
    
    private static int getPrice(int time){
        
        if(time <= fee.basicT) return fee.basicP;
        
        int unitPrice = (time - fee.basicT)/fee.unitT;
        int div = (time - fee.basicT)%fee.unitT;
        
        if(div != 0) unitPrice++;
        
        return fee.basicP + unitPrice*fee.unitP;
        
    }
}