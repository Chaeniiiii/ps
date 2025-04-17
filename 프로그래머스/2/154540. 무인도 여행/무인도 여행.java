import java.util.*;

class Solution {
    
    private static ArrayList<Integer> arr;
    private static boolean [][] visited;
    
    private static int col,row;
    
    private static int [] dx = {-1,1,0,0};
    private static int [] dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {

        row = maps.length;
        col = maps[0].length();
        
        arr = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i,j,maps);
                }
            }
        }
        
        if(arr.size() == 0) return new int[]{-1};
        
        arr.sort((a,b) -> a-b);
        int [] result = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++) result[i] = arr.get(i);
        
        return result;
    }
    
    private static void bfs(int x, int y, String [] maps){
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        
        int cnt = maps[x].charAt(y) - '0';
        
        while(!deque.isEmpty()){
        
            int [] mv = deque.poll();
            
            for(int i = 0; i<4; i++){
                
                int mvX = mv[0] + dx[i];
                int mvY = mv[1] + dy[i];
                
                if(mvX < 0 || mvY < 0 || mvX >= row || mvY >= col || 
                    maps[mvX].charAt(mvY) == 'X' || visited[mvX][mvY]) continue;
                
                visited[mvX][mvY] = true;
                deque.add(new int[]{mvX,mvY});
                cnt += (int)(maps[mvX].charAt(mvY) - '0');
                
            }
            
        }
        
        arr.add(cnt);
        
    }
}