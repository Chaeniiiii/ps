import java.util.*;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){

            int now = nums[i];
            int needNum = target-now;

            if(map.containsKey(needNum)) return new int[]{i,map.get(needNum)};
            map.put(now,i);

        }

        return new int[]{-1,-1};

        

    }
}