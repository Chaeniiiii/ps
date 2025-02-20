import java.util.*;

class Solution {
    public int solution(int[][] targets) {

        ArrayList<int[]> arr = new ArrayList<>();
        for(int [] trg : targets) arr.add(trg);
        
        arr.sort((a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int end = arr.get(0)[1];
        int cnt = 1;
        
        for(int i = 1; i<arr.size(); i++){
            if(arr.get(i)[0] >= end){
                cnt ++;
                end = arr.get(i)[1];
            }
        }
        
        return cnt;
        
    }
}