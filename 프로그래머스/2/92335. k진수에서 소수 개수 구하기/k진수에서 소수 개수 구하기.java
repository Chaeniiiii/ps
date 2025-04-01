import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        String number = Long.toString(n,k);
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char c : number.toCharArray()) deque.add(c);
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            char c = deque.poll();
            
            if(c == '0'){
                if(isPrime(Long.parseLong(sb.toString()))) cnt++;
                sb = new StringBuilder();
            }
            
            sb.append(c);
            
        }
        
        if(isPrime(Long.parseLong(sb.toString()))) cnt++;
        
        return cnt;
        
    }
    
    private static boolean isPrime(long num){
        
        if(num == 1 || num == 0) return false;
        
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
        
    }
}