import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int[][] newScores = new int[scores.length][3];
        for(int i = 0; i < scores.length; i++){
            int[] score = scores[i];
            newScores[i] = new int[]{i,score[0],score[1]};
                        
        }
        Arrays.sort(newScores,(a,b) -> {
            if(a[1] == b[1]) return a[2] - b[2];
            return b[1] - a[1];
        });
        
        int maxE = 0;
        int rank = 1;
        int wanho = scores[0][0] + scores[0][1];
        
        for(int i = 0; i < newScores.length; i++){
            int[] score = newScores[i];
            //지금까지 나온 동료평가 점수보다 낮으면 탈락 (앞서 나온 사원의 근무 태도 점수는 현재 사원의 근무 태도 점수보다 높음 )
            if(score[2] < maxE){
                if(score[0] == 0) return -1;
            }
            else{
                maxE = Math.max(maxE,score[2]);
                if(wanho < score[1] + score[2]) rank++;
            }
        }
        
        return rank;
        
    }
}