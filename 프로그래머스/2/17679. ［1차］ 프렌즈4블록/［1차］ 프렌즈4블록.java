import java.util.*;

class Solution {
    public int solution(int m, int n, String[] frd) {

        char [][] board = new char[m][n];
        
        //위치 접근이 쉽도록 2차원 배열에 삽입
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = frd[i].charAt(j);
            }
        }
        
        int [] dx = new int []{0,1,1};
        int [] dy = new int []{1,0,1};

        int total = 0;
        
        while(true){
            
            Set<int []> set = new HashSet<>();
            boolean [][] visited = new boolean[m][n];
            
            //지워질 인형 확인 
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    char c = board[i][j];
                    if(c == 'X') continue;
                    ArrayList<int []> arr = new ArrayList<>();
                    
                    arr.add(new int[]{i,j});
                    
                    for(int k = 0; k<3; k++){
                        int mvX = i+dx[k];
                        int mvY = j+dy[k];
                        
                        if(mvX < 0 || mvY < 0 || mvX >= m || mvY >= n || board[mvX][mvY] != c) {
                            arr.clear();
                            break;
                        }
                        
                        arr.add(new int[]{mvX,mvY});
                    }
                    
                    for(int [] ele : arr) {
                        if(!visited[ele[0]][ele[1]]){
                            visited[ele[0]][ele[1]] = true;
                            set.add(ele);
                        }
                    }
                }
            }
            
            // 지워질 인형들이 있으면, X로 마킹
            for(int [] s : set){
                board[s[0]][s[1]] = 'X';
            }
            
            
            // 지워진 인형이 없다면 종료
            if(set.size() == 0) break; 
            else total += set.size();
            
            
            // 빈 판 채우기
            for(int i = 0; i<n; i++){
                int cnt = 0;
                for(int j = m-1; j>=0; j--){
                    if(board[j][i] == 'X') cnt++;
                    else {
                        if(cnt != 0){
                            board[j+cnt][i] = board[j][i];
                            board[j][i] = 'X';
                        }
                    }
                }
            }
        }
        
        return total; 
    }
}
