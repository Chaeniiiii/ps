import java.util.*;

class Solution {
    
    private static ArrayList<Num> arr;
    private static class Num {
        
        int n;
        int cnt;
        
        private Num(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
        
    }
    
    public int[] solution(int e, int[] starts) {
        
        arr = new ArrayList<>();
        
        for(int i = 1; i <= e; i++){
            arr.add(new Num(i,1));
        }
        
        //약수의 개수 구하기
        for(int i = 2; i <= e; i++){
            for(int j = 1; j <= e / i; j++){
                arr.get(i * j - 1).cnt ++;
            }    
        }
        
        arr.sort((a,b) -> {
            
            if(a.cnt == b.cnt){
                return a.n - b.n;
            }
            
            return b.cnt - a.cnt;
        });
        
        int[] result = new int[starts.length];
        for(int i = 0; i < starts.length; i++){
            int now = starts[i];
            for(int j = 0; j < e; j++){
                if(arr.get(j).n >= now){
                    result[i] = arr.get(j).n;
                    break;
                }
            }
        }
        
        return result;
        
    }
    
}