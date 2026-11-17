import java.util.*;

class Solution {
    
    private int cnt;
    private Map<Integer,Integer> map;
    private boolean[] visited;
    
    public int solution(String numbers) {
        
        cnt = 0;
        map = new HashMap<>();
        visited = new boolean[numbers.length()];
        
        dfs(0,numbers, new StringBuilder());
        
        return cnt;
        
    }
    
    private void dfs(int dep, String numbers, StringBuilder sb){
        
        if(sb.length() != 0 && map.getOrDefault(Integer.parseInt(sb.toString()),0) == 0){
            int num = Integer.parseInt(sb.toString());
            map.put(num,1);
            if(isPrime(Integer.parseInt(sb.toString()))) cnt++;
        }
        
        if(dep == numbers.length()){
            return;    
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(numbers.charAt(i));
            dfs(dep+1,numbers,sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
        
    }
    
    private boolean isPrime(int num){
        
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
        
    }
    
}