class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        sb.append(1);
        
        int num = 2;
        while(sb.length() <= t*m){
            
            String str = getNum(n,num);
            for(char c : str.toCharArray()){
                sb.append(c);
            }
            num++;
            
        }
        
        StringBuilder result = new StringBuilder();
        int st = p-1;
        while(result.length() < t){
            result.append(sb.charAt(st));
            st+=m;
        }
        return result.toString();
        
    }
    
    private static String getNum(int n, int num){
        
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int div = num % n;
            num /= n;
            
            if(div >= 10) sb.append((char)('A' + (div - 10)));
            else sb.append(div);
            
        }
        
        return sb.reverse().toString();
        
    }
    
}