import java.util.*;

class Solution {
    
    private static int n,m;
    private static String[] maps;
    private static boolean[][] visited;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        this.maps = maps;
        visited = new boolean[n][m];
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char c = maps[i].charAt(j);
                if(!Character.isDigit(c) || visited[i][j]) continue;
                visited[i][j] = true;
                arr.add(bfs(i,j));
            }
        }
        
        if(arr.size() == 0) return new int[]{-1};
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }
        
        Arrays.sort(result);
        return result;
        
    }
    
    private static int bfs(int x, int y){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            int nx = now[0];
            int ny = now[1];
            cnt+= (int)maps[nx].charAt(ny) - '0';
            
            for(int i = 0; i < 4; i++){
                int mvX = nx + dx[i];
                int mvY = ny + dy[i];
                
                if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || visited[mvX][mvY]) continue;
                if(!Character.isDigit(maps[mvX].charAt(mvY))) continue;
                visited[mvX][mvY] = true;
                deque.add(new int[]{mvX,mvY});
            }
            
        }
        
        return cnt;
        
    }
    
}