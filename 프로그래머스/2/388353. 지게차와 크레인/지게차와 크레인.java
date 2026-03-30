import java.util.*;

class Solution {
    
    private static int n,m;
    
    private static char[][] board;
    private static boolean[][] visited;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    public int solution(String[] storage, String[] requests) {
        
        n = storage.length;
        m = storage[0].length();
        board = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            String str = storage[i];
            for(int j = 0; j < m; j++){
                board[i][j] = str.charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++){
            
            String now = requests[i];
            if(now.length() == 1){
                fork(now.charAt(0));
            }
            else{
                crane(now);
            }
            
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]) cnt++;
            }
        }
        
        return cnt;
        
    }
    
    private static void fork(char c){
        
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == c && !visited[i][j]){
                    if(isPossible(i,j)) deque.add(new int[]{i,j});
                }
            }
        }
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            visited[now[0]][now[1]] = true;
            
        }
        
    }
    
    private static void crane(String now){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == now.charAt(0)){
                    visited[i][j] = true;
                }
            }
        }
        
    }
    
    private static boolean isPossible(int sx, int sy){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sx,sy});
        
        boolean[][] nowV = new boolean[n][m];
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            nowV[x][y] = true;
            
            for(int i = 0; i < 4; i++){
                
                int mx = x + dx[i];
                int my = y + dy[i];
                
                if(mx < 0 || my < 0 || mx >= n || my >= m) return true;
                if(!nowV[mx][my] && visited[mx][my]) deque.add(new int[]{mx,my});
                
            }
            
        }
        
        return false;
        
    }
    
}