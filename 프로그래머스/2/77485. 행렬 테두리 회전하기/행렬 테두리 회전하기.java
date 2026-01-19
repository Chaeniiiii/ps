import java.util.*;

class Solution { 
    public int[] solution(int rows, int columns, int[][] queries) {
    
        int[][] board = init(rows,columns);
        int[][] newboard = new int[rows][columns];
        
        cloneArr(newboard, board);
        
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            
            int[] now = queries[i];
            int stx = now[0] - 1;
            int sty = now[1] - 1;
            
            int enx = now[2] - 1; 
            int eny = now[3] - 1;
            
            int x = stx, y = sty, cnt = Integer.MAX_VALUE;
            
            //오른쪽 방향
            for(; y < eny; y++){
                newboard[x][y+1] = board[x][y];
                cnt = Math.min(cnt,newboard[x][y+1]);
            }
            //아래쪽 방향
            for(; x < enx; x++){
                newboard[x+1][y] = board[x][y];
                cnt = Math.min(cnt,newboard[x+1][y]);
            }
            //왼쪽 방향
            for(; y > sty; y--){
                newboard[x][y-1] = board[x][y];
                cnt = Math.min(cnt,newboard[x][y-1]);
            }
            //위쪽 방향
            for(; x > stx; x--){
                newboard[x-1][y] = board[x][y];
                cnt = Math.min(cnt,newboard[x-1][y]);
            }
    
            cloneArr(board,newboard);
            result[i] = cnt;
            
        }
        
        return result;
        
    }
    
    private static void cloneArr(int[][] a, int[][] b){
        
        for(int i = 0; i < a.length; i++){
            a[i] = b[i].clone();
        }
        
    }
    
    private static int[][] init(int r, int c){
        
        int[][] board = new int[r][c];
        int num = 1;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                board[i][j] = num;
                num++;
            }
        }
        
        return board;
        
    }
    
}