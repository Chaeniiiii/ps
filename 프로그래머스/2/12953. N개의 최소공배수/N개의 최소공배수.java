class Solution {
    public int solution(int[] arr) {
        
        if(arr.length == 1) return arr[0];
        
        int numGcd = gcd(arr[0],arr[1]);
        int cnt = (arr[0] * arr[1])/numGcd;
        
        for(int i = 2; i<arr.length; i++){
            
            numGcd = gcd(cnt,arr[i]);
            cnt = (cnt * arr[i])/numGcd;
            
        }
        
        return cnt;
        
    }
    
    private static int gcd(int a, int b){
        
        int result = a % b;
        if(result == 0) return b;
        return gcd(b,result);
        
    }
} 