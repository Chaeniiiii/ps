import java.util.*;

class Solution {

    private static int n;
    private static final int SIZE = 6;

    private static int[] result;
    private static int max;

    private static int[][] dice;

    private static ArrayList<int[]> arr;     // A의 주사위 조합
    private static ArrayList<int[]> reverse; // B의 주사위 조합

    private static Map<String, ArrayList<Integer>> map; // 조합의 합 저장용

    public int[] solution(int[][] dice) {

        n = dice.length;
        this.dice = dice;

        arr = new ArrayList<>();
        reverse = new ArrayList<>();
        map = new HashMap<>();

        dfs(0, 0, new boolean[n]);

        result = new int[n / 2];
        max = Integer.MIN_VALUE;

        for (int k = 0; k < arr.size(); k++) {
            fight(k);
        }
        
        for (int i = 0; i < result.length; i++) {
            result[i]++;
        }
       
        return result;
        
    }

    private static void dfs(int idx, int dep, boolean[] visited) {

        if (dep == n / 2) {

            int[] now = new int[n / 2];
            int[] opp = new int[n / 2];
            int i = 0, j = 0;

            for (int k = 0; k < n; k++) {
                if (visited[k]) now[i++] = k;
                else opp[j++] = k;
            }

            arr.add(now);
            reverse.add(opp);

            // A의 주사위 조합 합 계산
            calcSum(now);

            return;
        }

        for (int k = idx; k < n; k++) {
            visited[k] = true;
            dfs(k + 1, dep + 1, visited);
            visited[k] = false;
        }
    }

    private static void calcSum(int[] now) {
        String key = Arrays.toString(now);
        map.computeIfAbsent(key, v -> new ArrayList<>());
        calcSum2(0, 0, now, key);
        map.get(key).sort((a, b) -> a-b);
    }

    
    private static void calcSum2(int dep, int sum, int[] now, String key) {
        if (dep == n/2) {
            map.get(key).add(sum);
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            calcSum2(dep + 1, sum + dice[now[dep]][i], now, key);
        }
    }

    private static void fight(int k) {

        int[] now = arr.get(k);
        int[] opp = reverse.get(k);

        String nowKey = Arrays.toString(now);
        String oppKey = Arrays.toString(opp);

        ArrayList<Integer> origin = map.get(nowKey);
        ArrayList<Integer> target = map.get(oppKey);

        int wCnt = 0, lCnt = 0;

        for (int i = 0; i < origin.size(); i++) {

            int num = origin.get(i);
            int lt = 0, rt = target.size();
            
            while (lt < rt) {
                int mid = (lt + rt) / 2;
                int targetNum = target.get(mid);

                if (targetNum < num) lt = mid + 1;
                else rt = mid;
                
            }

            wCnt += lt;
            
        }

        if (max < wCnt) {
            max = wCnt;
            result = now.clone();
        }
    }
}
