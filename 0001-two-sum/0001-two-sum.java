class Solution {

    private static class Num {

        int score;
        int idx;

        private Num(int score,int idx){
            this.score = score;
            this.idx = idx;
        }
    }

    public int[] twoSum(int[] nums, int target) {

        ArrayList<Num> arr = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) arr.add(new Num(nums[i],i));

        int left = 0, right = nums.length-1;
        arr.sort((a,b) -> a.score-b.score);
        
        while(left < right){

            int cnt = arr.get(left).score + arr.get(right).score ;
            if(cnt < target) left ++;
            else if(cnt > target) right --;
            else break;

        }

        return new int[]{arr.get(left).idx,arr.get(right).idx};


    }
}