import java.util.*;

class Solution {
    
    private static final int SIZE = 5;
    
    private static class Pos {
        
        int x;
        int y;
        
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }
    
    public int[] solution(String[][] places) {
        
        int tc = places.length;
        int [] result = new int[tc];
        
        for(int t = 0; t<tc; t++){
            
            result[t] = simulate(places[t]);
            
        }
        
        return result;
        
    }
    
    private static int simulate(String [] place){
        
        boolean [][] visited = new boolean[SIZE][SIZE];
            
        int [] dx = new int[]{-1,1,0,0,1,1,-1,-1};
        int [] dy = new int[]{0,0,-1,1,1,-1,1,-1};

        for(int i = 0; i<SIZE; i++){
            for(int j = 0; j<SIZE; j++){

                if(place[i].charAt(j) != 'P' || visited[i][j]) continue;

                Deque<Pos> deque = new ArrayDeque<>();
                deque.add(new Pos(i,j));
                visited[i][j] = true;

                while(!deque.isEmpty()){

                    Pos pos = deque.poll();

                    //상하좌우 -> 맨해튼 거리가 2이하인 위치 확인
                    for(int k = 0; k<4; k++){

                        int mvX = pos.x + dx[k];
                        int mvY = pos.y + dy[k];

                        if(!isVisited(visited,mvX,mvY)) continue;

                        char c = place[mvX].charAt(mvY);
                        if(c == 'P') return 0;

                        //맨해튼거리 2인 곳 확인
                        int nxtX = mvX + dx[k];
                        int nxtY = mvY + dy[k];

                        if(!isVisited(visited,nxtX,nxtY)) continue;
                        if(place[nxtX].charAt(nxtY) == 'P' && c == 'O') return 0;
                        if(place[nxtX].charAt(nxtY) == 'P' && c == 'X'){
                            deque.add(new Pos(nxtX,nxtY));
                        visited[nxtX][nxtY] = true;
                        }
                        
                    }

                    //응시자의 대각선 확인 
                    for(int k = 4; k<8; k++){
                        int mvX = pos.x + dx[k];
                        int mvY = pos.y + dy[k];

                        if(!isVisited(visited,mvX,mvY)) continue;
                        if(place[mvX].charAt(mvY) != 'P') continue;
                        
                        if(!isVisited(visited,mvX,pos.y) || !isVisited(visited,pos.x,mvY)) continue;
                        if(place[mvX].charAt(pos.y) != 'X' || place[pos.x].charAt(mvY) != 'X') return 0;

                        deque.add(new Pos(mvX,mvY));
                        visited[mvY][mvY] = true;
                    }

                }

            }
        }
        
        return 1;
    }
    
    private static boolean isVisited(boolean [][] visited, int x, int y){
        
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE || visited[x][y]) return false;
        return true;
        
    }
}