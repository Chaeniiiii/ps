import java.util.*;

class Solution {
    
    private static final int MAXT = 10000;
    
    public int solution(int n, int[] cores) {
        
        int lt = 1, rt = MAXT*n;
        
        int len = cores.length;
        
        int time = 0;
        int task = 0;
        int result = 0;
        
        while(lt <= rt){
            
            int mid = (lt + rt) / 2;
            int workCnt = work(cores,mid);
            
            if(workCnt < n){
                lt = mid + 1;
            }
            else{
                rt = mid - 1;
                time = mid;
                task = workCnt;
            }
            
        }
        
        task -= n;
        for(int i = len - 1; i >= 0; i--){
            if(time % cores[i] == 0){
                if(task == 0){
                    result = i + 1;
                    break;
                }
                task-- ;
            }
        }
        
        return result;
        
    }
    
    private static int work(int[] cores, int time){
        
        int cnt = cores.length;
        
        for(int i = 0 ; i < cores.length ; i++){
            cnt += time / cores[i];
        }
        
        return cnt;
        
    }
    
}