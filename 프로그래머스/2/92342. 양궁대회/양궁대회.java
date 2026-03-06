import java.util.*;

class Solution {
    
    private static final int SIZE = 10;
    
    private static int diff = 0;
    
    private static int[] info;
    private static int[] lion;
    
    public int[] solution(int n, int[] info) {
        
        this.info = info;
        lion = new int[SIZE + 1];
        
        dfs(0, n, new int[SIZE+1]);
        
        return diff == 0 ? new int[]{-1} : lion;
        
    }
    
    private static void dfs(int idx, int n, int[] point){
        
        if(n < 0) return;
        if(n == 0){
            //점수 계산
            int a = 0; int l = 0;
            for(int i = 0; i <= SIZE; i++){
                int score = SIZE - i;
                if(info[i] == 0 && point[i] == 0) continue;
                if(info[i] < point[i]) l+= score;
                else a += score;
            }
            
            //어피치가 이기거나 점수 차이가 기존보다 적을 경우 제외
            if(a >= l || diff > Math.abs(a-l)) return;
            
            //더 작은 점수를 많이 쏜 경우 판별
            
            for(int i = SIZE; i >= 0; i--){
                if(lion[i] < point[i]){
                    lion = point.clone();
                    break;
                }
                if(diff == Math.abs(a-l) && lion[i] > point[i]) break;
            }
            diff = Math.abs(a-l);
            
            return;
        }
        
        for(int i = idx; i <= SIZE; i++){
            
            //라이언이 이기는 경우
            point[i] = i == SIZE ? n : info[i] + 1;
            dfs(i+1,n - point[i],point);
            point[i] = 0;
            
            //어피치가 이기는 경우(라이언이 쏘지 않는 경우)
            dfs(i+1,n,point);
        }
        
    }
    
    
}