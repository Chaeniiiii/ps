class Solution {
    public int solution(int m, int n, int[][] cityMap) {
        int MOD = 20170805;
        int[][][] dp = new int[m][n][2];

        // 시작점 초기화
        dp[0][0][0] = dp[0][0][1] = 1;

        // 첫 열: 아래 방향만 존재
        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) break; // 통제 지점 지나면 그 아래 모두 막힘
            dp[i][0][0] = dp[i - 1][0][0];
        }
        // 첫 행: 오른쪽 방향만 존재
        for (int j = 1; j < n; j++) {
            if (cityMap[0][j] == 1) break;
            dp[0][j][1] = dp[0][j - 1][1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue; // 통행 금지

                // 위에서 아래(도)
                if (cityMap[i - 1][j] == 0) {
                    dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                } else if (cityMap[i - 1][j] == 2) {
                    dp[i][j][0] = dp[i - 1][j][0];
                }
                // 왼쪽에서 오른쪽(우)
                if (cityMap[i][j - 1] == 0) {
                    dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                } else if (cityMap[i][j - 1] == 2) {
                    dp[i][j][1] = dp[i][j - 1][1];
                }
            }
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }


}