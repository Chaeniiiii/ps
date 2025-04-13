class Solution {
    public int[] solution(int n) {
        
        int [][] board = new int[n][n];
        int [] result = new int[(n*(n+1))/2];
        
        int num = 1;
        int x = -1, y = 0;
        
        for(int i = 0; i<n; i++){ //이동 횟수 ⬇️➡️↖️⬇️
            for(int j = i; j<n; j++){ //이동 횟수 별 채워야 하는 칸 개수
                //3으로 나누는 이유 ? 이동하는 방향이 총 3가지
                if(i%3 == 0) x++; 
                else if(i%3 == 1) y++;
                else if(i%3 == 2){
                    x--;
                    y--;
                }
                
                board[x][y] = num;
                num++;
                
            }
            
        }
        
        int idx = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 0) continue;
                result[idx] = board[i][j];
                idx++;
            }
        }
        
        return result;
                      
    }
}