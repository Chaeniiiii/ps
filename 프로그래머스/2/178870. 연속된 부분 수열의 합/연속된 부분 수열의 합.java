import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int lt = 0, rt = 0, sum = sequence[rt];
        int[] result = new int[]{0,Integer.MAX_VALUE};
        
        while(rt < sequence.length && lt <= rt){
            
            System.out.printf("%d %d %d\n",lt,rt,sum);
            
            if(sum < k){
                rt++;
                sum += sequence[rt];
                
            }
            else if(sum > k){
                sum -=sequence[lt];
                lt++;
            }
            else{
                if(result[1] - result[0] > rt - lt){
                    result[0] = lt;
                    result[1] = rt;
                }
                rt++;
                sum += sequence[rt];
            }
            
        }
        
        return result;
        
    }
}