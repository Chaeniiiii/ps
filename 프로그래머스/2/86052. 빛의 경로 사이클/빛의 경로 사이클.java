import java.util.*;

class Solution {
    
    private static int n,m;
    private static char[][] board;
    
    private static int[] dx = new int[]{-1,0,1,0};
    private static int[] dy = new int[]{0,-1,0,1};
    
    private static boolean[][][] visited;
    private static ArrayList<Integer> arr; //사이클 경로 길이 저장할 리스트
    
    public int[] solution(String[] grid) {
        
        n = grid.length;
        m = grid[0].length();
        
        arr = new ArrayList<>();
        visited = new boolean[n][m][4];
        
        //1. 2차원 배열 생성
        board = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = grid[i].charAt(j);
            }
        }
        
        //2. 사이클 찾기
        
        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                for(int k = 0; k < 4; k++){
                    int cnt = 0;
                    while(!visited[x][y][k]){
                        visited[x][y][k] = true;
                        cnt++;
                        
                        if(board[x][y] == 'R') k = (k + 3) % 4;
                        else if(board[x][y] == 'L') k = (k + 1) % 4;
                        
                        x = (x + n + dx[k]) % n;
                        y = (y + m + dy[k]) % m;
                    }
                    
                    if(cnt > 0) arr.add(cnt);
                    
                }
            }
        }
        
        arr.sort((a,b) -> a - b);
        
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            result[i] = arr.get(i);
        }
        
        return result;
         
    }
    
    private static void dfs(int x, int y, int d, int cnt){
        
        if(visited[x][y][d]){
            if(cnt > 0) arr.add(cnt);
            return;
        }

        visited[x][y][d] = true;
        
        int k = d;
        switch(board[x][y]){
            case 'R':
                k = (k + 3) % 4;
                break;
            case 'L':
                k = (k + 1) % 4;
                break;
        }
        
        int nx = (x + dx[k] + n) % n;
        int ny = (y + dy[k] + m) % m;
        
        dfs(nx,ny,k,cnt+1);
            
    }
    
}