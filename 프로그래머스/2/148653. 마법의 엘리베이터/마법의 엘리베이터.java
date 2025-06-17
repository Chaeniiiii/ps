import java.util.*;

class Solution {
    
    private static int cnt;
    
    public int solution(int storey) {
        
        String storeyStr = String.valueOf(storey);
        
        int[] nums = new int[storeyStr.length()];
        cnt = 0;
        
        for(int i = 0; i < storeyStr.length(); i++){
            char c = storeyStr.charAt(i);
            nums[i] = c -'0';
        }
            
        for(int i = nums.length - 1; i >= 0; i--){
            
            int num = nums[i];
            
            if(num > 5){
                cnt += (10 - num);
                nums = upNext(nums,i-1,i,true);
            }
            else if(num < 5){
                cnt += num;   
            }
            else{
                cnt += 5;
                nums = upNext(nums,i-1,i,false);
            }
            
        }        
        
        return cnt;
        
    }
    
    private static int[] upNext(int[] nums, int prev, int now, boolean up){
        
        if(prev < 0){
            if(nums[now] > 5){
                cnt++;
            }
            return nums;
        }
        
        nums[now] = 0;
        if(up || (!up && nums[prev] >= 5)) nums[prev]++;
        
        return nums;
        
    }
    
}