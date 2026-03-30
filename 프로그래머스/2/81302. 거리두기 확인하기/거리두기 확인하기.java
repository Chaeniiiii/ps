import java.util.*;

class Solution {
    
    private final int SIZE = 5;
    
    private int[] dx = new int[]{-1,1,0,0};
    private int[] dy = new int[]{0,0,-1,1};
    private boolean[][] visited;
    
    public int[] solution(String[][] places) {
        
        int[] result = new int[places.length];
        for(int t = 0; t < places.length; t++){
            String[] pc = places[t];
            boolean possible = true;
            visited = new boolean[SIZE][SIZE];
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    if(pc[i].charAt(j) == 'P'){
                        if(bfs(i,j,pc) == 0){
                            possible = false;
                            break;
                        }
                    }
                }
            }
            result[t] = possible ? 1 : 0;
        }
        
        return result;
        
    }
    
    private int bfs(int x, int y, String[] pc){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        visited[x][y] = true;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            
            for(int k = 0; k < 4; k++){
                
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE || visited[nx][ny] || pc[nx].charAt(ny) == 'X') continue;
                if(pc[nx].charAt(ny) == 'P') return 0;
                
                if(Math.abs(x - nx) + Math.abs(y - ny) >= 2) continue;
                deque.add(new int[]{nx,ny});
                visited[nx][ny] = true;
                 
            }
            
        }
        
        return 1;
        
    }
}