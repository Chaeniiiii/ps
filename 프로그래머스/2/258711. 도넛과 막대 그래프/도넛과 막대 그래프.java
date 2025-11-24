import java.util.*;

class Solution {
    
    private static final int MAX = 1_000_000;
    
    public int[] solution(int[][] edges) {
        
        int[] in = new int[MAX+1];
        int[] out = new int[MAX+1];
        
        int maxN = 0;
        for(int[] edge : edges){
            in[edge[1]]++;
            out[edge[0]]++;
            
            maxN = Math.max(maxN,Math.max(edge[0],edge[1]));
        }
        
        int[] result = new int[4];
        for(int i = 1; i <= maxN; i++){
            
            if(in[i] == 0 && out[i] >= 2){
                result[0] = i;
            }
            else if(in[i] > 0 && out[i] == 0){
                result[2]++;
            }
            else if(in[i] >= 2 && out[i] >= 2){
                result[3]++;
            }
        }
        
        result[1] = out[result[0]] - (result[2] + result[3]);
        
        return result;
        
    }
}