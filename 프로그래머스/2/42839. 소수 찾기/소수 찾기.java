import java.util.*;

class Solution {
    
    private static int cnt;
    private static String numbers;
    
    private static Set<Integer> set;
    private static boolean[] visited;
    
    public int solution(String numbers) {
        
        cnt = 0;
        set = new HashSet<>();
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        dfs(0,new StringBuilder());
        
        return cnt;
        
    }
    
    private static void dfs(int dep, StringBuilder sb){
        
        if(dep > numbers.length()) return;
        
        if(sb.length() > 0 && isPrime(sb.toString())) cnt++;
        
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(numbers.charAt(i));
            dfs(dep+1,sb);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
        
    }
    
    private static boolean isPrime(String str){
        
        int num = Integer.parseInt(str);
        if(set.contains(num) || num == 0 || num == 1) return false;
        set.add(num);
        
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
        
    }
    
    
}