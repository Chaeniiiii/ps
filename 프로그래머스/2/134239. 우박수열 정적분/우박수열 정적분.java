import java.util.*;

class Solution {
    
    private static ArrayList<Double> y;
    
    public double[] solution(int k, int[][] ranges) {
        
        double[] result = new double[ranges.length];
            
        y = new ArrayList<>();
        int cnt = collatz(k);
        
        double[] sum = new double[y.size() - 1];
        for(int i = 0; i < y.size() - 1; i++){
            double ext = (y.get(i) + y.get(i+1)) / 2;
            sum[i] = ext;
        }
        
        for(int i = 0; i < ranges.length; i++){
            
            int[] rg = ranges[i];
            int x1 = rg[0];
            int x2 = rg[1] <= 0 ? cnt + rg[1] : rg[1];
            
            if(x2 < x1){
                result[i] = -1.0;
                continue;
            }
            
            double extSum = 0;
            for(int j = x1; j < x2; j++){
                extSum += sum[j];
            }
            
            result[i] = extSum;
            
        }
        
        return result;
        
    }
    
    private static int collatz(int k){
        
        y.add((double)k);
        
        if(k == 1) return 0;
        if(k % 2 == 0){
            return 1 + collatz(k/2);
        }
        else{
            return 1 + collatz(k*3+1);
        }
        
    }
    
}