import java.util.*;

class Solution {
    
    private static ArrayList<int[]> seq;
    
    public int[][] solution(int n) {
        
        seq = new ArrayList<>();
        hanoi(n,1,3,2);
        
        int[][] result = new int[seq.size()][2];
        for(int i = 0; i < seq.size(); i++){
            result[i] = seq.get(i);
        }
        
        return result;
        
    }
    
    private static void hanoi(int n, int st, int en, int via){
        
        if(n == 1){
            seq.add(new int[]{st,en});
        }
        else{
            hanoi(n-1,st,via,en);
            seq.add(new int[]{st,en});
            hanoi(n-1,via,en,st);
        }
        
    }
    
}