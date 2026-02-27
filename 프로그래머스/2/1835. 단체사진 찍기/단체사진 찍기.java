import java.util.*;

class Solution {
    
    private static final int MAX = 8;
    
    private static int result;
    private static char[] frd;
    private static boolean[] visited;
    private static String[] data;
    
    public int solution(int n, String[] data) {
        
        this.data = data;
        frd = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        
        result = 0;
        visited = new boolean[MAX];
        dfs(new StringBuilder());
        
        return result;
        
    }
    
    private static void dfs(StringBuilder sb){
        
        if(sb.length() == 8){
            if(isPossible(sb)) result++;
            return;
        }
        
        for(int i = 0; i < MAX; i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(frd[i]);
            dfs(sb);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
        
    }
    
    private static boolean isPossible(StringBuilder sb){
        
        for(int i = 0; i < data.length; i++){
            String str = data[i];
            String a = String.valueOf(str.charAt(0)); //본인
            String b = String.valueOf(str.charAt(2)); //상대방
            char c = str.charAt(3); //조건
            int d = str.charAt(4) - '0';//거리
            
            int realD = Math.abs(sb.indexOf(a) - sb.indexOf(b)) - 1;
            switch(c){
                case '<':
                    if(realD >= d) return false;
                    break;
                case '>':
                    if(realD <= d) return false;
                    break;
                case '=':
                    if(Math.abs(realD - d) != 0) return false;
                    break;
                        
            }
            
        }
        
        return true;
        
    }
    
}