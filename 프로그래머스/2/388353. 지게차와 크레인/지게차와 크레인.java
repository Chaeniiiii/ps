import java.util.*;

class Solution {
    
    private int n,m,cnt;
    private String[] storage;
    private boolean[][] visited;
    
    private int[] dx = new int[]{-1,1,0,0};
    private int[] dy = new int[]{0,0,-1,1};
    
    public int solution(String[] storage, String[] requests) {
        
        this.storage = storage;
        
        n = storage.length;
        m = storage[0].length();
        cnt = n*m;
        
        visited = new boolean[n][m];
        
        for(int i = 0; i < requests.length; i++){
            
            String rq = requests[i];
            int len = rq.length();
            
            char c = rq.charAt(0);
            
            if(len == 1){ //지게차
                fork(c);
            } 
            else{ //크레인 
                crane(c);
            }
        }
        
        return cnt;
        
    }
    
    private void crane(char c){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(storage[i].charAt(j) != c || visited[i][j]) continue;
                visited[i][j] = true;
                cnt--;
            }
        }
        
    }
    
    private void fork(char c){
        
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if(storage[x].charAt(y) == c && !visited[x][y] && isPossible(x,y,c)){
                    arr.add(new int[]{x,y});
                    cnt--;
                }
            }
        }
        
        for(int[] pos : arr){
            visited[pos[0]][pos[1]] = true;
        }
        
    }
    
    private boolean isPossible(int x, int y, char c){
        
        if(x == 0 || y == 0 || x == n-1 || y == m - 1) return true;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        boolean[][] nowVisited = new boolean[n][m];
        nowVisited[x][y] = true;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            
            for(int k = 0; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || !visited[nx][ny] || nowVisited[nx][ny]) continue;
                if((nx == 0 || ny == 0 || nx == n - 1 || ny == m - 1) && visited[nx][ny]) return true;
                
                nowVisited[nx][ny] = true;
                if(visited[nx][ny]) deque.add(new int[]{nx,ny});
                
            }
            
        }
        
        return false;
    }
    
}