import java.util.*;

class Solution {
    
    private static int n,m;
    private static String[] maps;
    private static boolean[][] visited;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    public int[] solution(String[] maps) {
        
        this.maps = maps;
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char c = maps[i].charAt(j);
                if(c == 'X' || visited[i][j]) continue;
                visited[i][j] = true;
                int cnt = bfs(i,j);
                if(cnt == 0) continue;
                arr.add(cnt);
            }
        }
        
        if(arr.size() == 0) return new int[]{-1};
        arr.sort((a,b) -> a - b);
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    private static int bfs(int x, int y){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        int cnt = 0;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            cnt+=maps[now[0]].charAt(now[1]) - '0';
            
            for(int i = 0; i < 4; i++){
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                
                if(mx < 0 || my < 0 || mx >= n || my >= m || visited[mx][my] || maps[mx].charAt(my) == 'X') continue;
                deque.add(new int[]{mx,my});
                visited[mx][my] = true;
            }
                        
        }
        
        return cnt;
        
    }
    
    
}