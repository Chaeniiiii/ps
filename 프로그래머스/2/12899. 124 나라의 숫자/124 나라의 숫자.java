class Solution {

    private static final int MOD = 3;
    
    public String solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"4", "1", "2"};
        
        int num = n;
        
        while(num > 0){
            
            int remain = num % MOD;
            num /= MOD;
            
            if(remain == 0) num --;

            sb.append(numbers[remain]);
            
        }
        
        return sb.reverse().toString();
        
    }
    
   
}
