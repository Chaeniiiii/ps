import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int n = progresses.length;
        
        int[] p = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = 100 - progresses[i];
        }
        
        System.out.println(Arrays.toString(p));
        
        int prev = 0, cnt = 0, div;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            
            div = (p[i] / speeds[i]) + ((p[i] % speeds[i]) == 0 ? 0 : 1);
            System.out.printf("%d %d\n",div,prev);
            
            if(div <= prev){
                cnt++;
                arr.add(cnt);
                cnt = 1;
            }
            else{
                cnt++;
            }
            prev = div;
        }
        if(cnt > 1) arr.add(cnt);
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            result[i] = arr.get(i);
        }
        
        return result;
        
    }
}