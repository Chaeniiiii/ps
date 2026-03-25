import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        long factorial = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add(i);
            factorial *= i;
        }
        
        int[] result = new int[n];
        int idx = 0;

        k--;
        while(idx < n){
            
            factorial /= (n-idx); //앞자리부터 차례대로 수가 하나씩 고정되었을 때, 가질 수 있는 순열의 개수
            
            int p = (int)(k / factorial);
            
            result[idx++] = arr.get(p);
            arr.remove(p);
            
            k %= factorial;
            
        }
        
        return result;
        
    }
}