import java.util.*;

class Solution {
    
    private static final int SIZE = 5;
    
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    private static int[] daX = new int[]{1,1,-1,-1};
    private static int[] daY = new int[]{1,-1,1,-1};

    private static class Pos{
        int x;
        int y;
        private Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[][] places) {
        
        int[] result = new int[SIZE];
        Arrays.fill(result,1);
        
        for(int t = 0; t < SIZE; t++){
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    if(places[t][i].charAt(j) == 'P'){
                        if(!isPossible(places[t],i,j)){
                            result[t] = 0;
                            break;
                        }
                    }
                }
            }
        }
        
        return result;
        
    }
    
    private static boolean isPossible(String[] place, int x, int y){
        
        //상하좌우 맨해튼거리 1 ~ 2 확인
        for(int i = 0; i < 4; i++){
            int mvX = x+dx[i];
            int mvY = y+dy[i];
            //해당 좌표가 대기실 밖이거나 파티션일 경우
            if(!isIn(mvX,mvY) || place[mvX].charAt(mvY) == 'X') continue;
            //맨해튼거리가 1인 위치에 응시자가 있을 경우
            if(place[mvX].charAt(mvY) == 'P') return false;
            //맨해튼거리가 2인 위치에 응시가자 앉아있을 경우
            mvX+=dx[i];
            mvY+=dy[i];
            if(isIn(mvX,mvY) && place[mvX].charAt(mvY) == 'P') return false;
        }
        
        //대각선 확인
        for(int i = 0; i < 4; i++){
            int mvX = x+daX[i];
            int mvY = y+daY[i];
            if(!isIn(mvX,mvY)) continue;
            if(place[mvX].charAt(mvY) == 'P' && (place[x].charAt(mvY) != 'X' || place[mvX].charAt(y) != 'X')) return false;
        }
        
        return true;
        
    } 
    
    private static boolean isIn(int x, int y){
        
        if(x < 0 || y < 0 || x >= SIZE || y >=SIZE) return false;
        return true;
        
    }
    
}