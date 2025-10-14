import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        
        int MOD = 10007;
        
        int[] tri = new int[n + 1];
        int[] rvsTri = new int[n + 1];
        
        tri[1] = 1;
        if(tops[0] == 1) rvsTri[1] = 3;
        else rvsTri[1] = 2;
        
        for(int i = 2; i <= n; i++){
            tri[i] = (tri[i - 1] + rvsTri[i - 1]) % MOD;
            
            if(tops[i - 1] == 1){
                rvsTri[i] = (tri[i - 1] * 2 + rvsTri[i - 1] * 3) % MOD;
            }
            else{
                rvsTri[i] = (tri[i - 1] + rvsTri[i - 1] * 2) % MOD;
            }
        }
        
        return (tri[n] + rvsTri[n]) % MOD;
        
    }
}