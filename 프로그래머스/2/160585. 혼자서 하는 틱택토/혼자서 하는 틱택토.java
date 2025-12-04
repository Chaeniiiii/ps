import java.util.*;

class Solution {
    
    private static int n,m;
    private static boolean[][] visited;
    
    private static String[] board;
    private static int[] dx = new int[]{-1,1,0,0,-1,-1,1,1};
    private static int[] dy = new int[]{0,0,-1,1,-1,1,-1,1};
    
    public int solution(String[] board) {
        
        n = board.length;
        m = board[0].length();
        this.board = board;
        
                
        int cntO = 0, cntX = 0;
        boolean bingoO = false, bingoX = false;
        
        for(int i = 0; i < board[0].length(); i++){
            for(int j = 0; j < board.length; j++){
                char c = board[i].charAt(j);
                visited = new boolean[n][m];
                switch(c){
                    case 'O':
                        cntO++;
                        if(!visited[i][j]){
                            visited[i][j] = true;
                            bingoO |= checkBG(i,j,-1,1);
                        }
                        break;
                    case 'X':
                        cntX++;
                        if(!visited[i][j]){
                            visited[i][j] = true;
                            bingoX |= checkBG(i,j,-1,1);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        
        //1. O가 만들어졌는데 X와 O의 개수가 같을 때
        //2. X가 만들어졌는데 O의 개수가 X보다 한 개 많을 때
        //3. X의 개수가 O보다 많을 때
        //4. O의 개수가 X보다 2개 많을 때
        if(bingoO && cntO == cntX || bingoO && bingoX) return 0;
        if(bingoX && cntO == cntX + 1) return 0;
        if(cntX > cntO) return 0;
        if(cntO - cntX >= 2) return 0;
        
        return 1;
        
    }
    
    private static boolean checkBG(int x, int y, int dir, int cnt){
        
        char now = board[x].charAt(y);
        
        if(cnt == 3){
            return true;
        }
        
        boolean result = false;
        for(int k = 0; k < 8; k++){
            
            int mvX = x + dx[k];
            int mvY = y + dy[k];
            
            if(mvX < 0 || mvY < 0 || mvX >= n || mvY >= m || visited[mvX][mvY] || board[mvX].charAt(mvY) != now) continue;
            if(dir == -1){
                visited[mvX][mvY] = true;
                result |= checkBG(mvX,mvY,k,cnt+1);
            }
            else if(dir == k){
                visited[mvX][mvY] = true;
                result |= checkBG(mvX,mvY,k,cnt+1);
            }
            
        }

        return result;
        
    }
}