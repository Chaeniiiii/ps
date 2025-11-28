import java.util.*;

class Solution {
    
    private static int result = 0;
    
    private static String numbers;
    
    private static boolean[] visited;
    private static Map<Integer,Integer> map;
    
    public int solution(String numbers) {
        
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        map = new HashMap<>();
        
        dfs(new StringBuilder(),0);
        
        return result;
        
    }
    
    private static void dfs(StringBuilder sb, int dep){
        
        int len = sb.length();
        
        if(dep > numbers.length()) return;
        if(len > 0 && dep <= numbers.length()){
            int num = Integer.parseInt(sb.toString());
            if(map.get(num) == null && isPrime(num)) result++;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(numbers.charAt(i));
            dfs(sb,dep+1);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
        
    }
    
    private static boolean isPrime(int num){
        
        if(num == 0 || num == 1) return false;
        map.put(num,map.getOrDefault(num,0)+1);
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
        
    }
    
}