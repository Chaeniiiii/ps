import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int len = people.length;
        
        int lt = 0, rt = len - 1;
        int result = 0;
            
        while(lt <= rt){
            
            int sum = people[rt] + (lt == rt ? 0 : people[lt]);
            if(sum <= limit){
                lt++;
            }
            
            rt--;
            result++;
            
        }
        
        return result;
        
         
    }
}