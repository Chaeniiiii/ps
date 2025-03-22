import java.util.*;

class Solution {
    
    private static int size;
    private static int cnt;
    
    private static int [] numArr;
    private static boolean [] visited;
    
    private static Set<Integer> set;
    
    public int solution(String numbers) {
        
        size = numbers.length();
        
        numArr = new int[size];
        for(int i = 0; i<size; i++){
            numArr[i] = numbers.charAt(i) - '0';
        }
        
        cnt = 0;
        visited = new boolean[size];
        set = new HashSet<>();
        dfs(0,0);
        
        return cnt;
        
    }
    
    private static void dfs(int n, int dep){
        if(dep <= size){
            if(!set.contains(n)){
                //소수 판별 
                if(isPrime(n)) cnt ++;
                set.add(n);
            }
        }
        
        // if(dep == size) return;
        
        for(int i = 0 ; i<size; i++){
            
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(n*10+numArr[i],dep+1);
            visited[i] = false;  
            
        }
    }
    
    private static boolean isPrime(int num){
        
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
}