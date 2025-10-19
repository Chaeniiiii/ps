import java.util.*;

class Solution {
    
    private static class Num{
        int n;
        int cnt;
        
        private Num(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(int e, int[] starts) {
        
        int[] result = new int[starts.length];
        ArrayList<Num> arr = new ArrayList<>();
        for(int i = 1; i <= e; i++){
            arr.add(new Num(i,1));
        }    
        
        for(int i = 1; i <= e; i++){
            for(int j = 1; j <= e/i; j++){
                arr.get(i*j-1).cnt++;
            }
        }
        
        arr.sort((a,b) -> b.cnt - a.cnt);
        
        for(int i = 0; i < starts.length; i++){
            int target = starts[i];
            for(int j = 0; j < arr.size(); j++){
                if(arr.get(j).n >= target){
                    result[i] = arr.get(j).n;
                    break;
                }
            }
        }
        
        return result;
        
    }
}