import java.util.*;

class Solution {

    private static class Score {
        int idx;
        int attd;
        int evl;
        int total;

        private Score(int idx, int attd, int evl) {
            this.idx = idx;
            this.attd = attd;
            this.evl = evl;
            this.total = attd + evl;
        }
    }

    public int solution(int[][] scores) {

        int n = scores.length;

        if (n == 1) return 1;

        ArrayList<Score> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Score(i, scores[i][0], scores[i][1]));
        }

        arr.sort((a, b) -> {
            if (b.attd == a.attd) return a.evl - b.evl;
            return b.attd - a.attd;
        });

        ArrayList<Score> valid = new ArrayList<>();
        int maxEvl = 0;

        for (Score now : arr) {
            if (now.evl < maxEvl) {
                if (now.idx == 0) return -1; 
                continue;
            }
            maxEvl = Math.max(maxEvl, now.evl);
            valid.add(now);
        }

        valid.sort((a, b) -> b.total - a.total); 

        int rank = 1;
        int count = 1;
        int prevTotal = valid.get(0).total;

        if (valid.get(0).idx == 0) return 1;

        for (int i = 1; i < valid.size(); i++) {
            Score now = valid.get(i);
            if (now.total < prevTotal) {
                rank += count;
                count = 1;
            } else {
                count++;
            }

            if (now.idx == 0) return rank;
            prevTotal = now.total;
            
        }

        return -1; 
    }
}
