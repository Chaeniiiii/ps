// [2, 3, 2]     [5, 4, 3]
// [4, 2, 4]     [2, 4, 1]
// [3, 1, 4]     [3, 1, 1]

// [1, 4]   [3, 3]
// [3, 2]   [3, 3]
// [4, 1]

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i<arr1.length; i++){
            for(int j = 0; j<arr2[0].length;j++){
                int cnt = 0;
                for(int k = 0; k<arr1[0].length; k++){
                    cnt += (arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = cnt;
            }
        }
        
        return answer;
        
    }
}