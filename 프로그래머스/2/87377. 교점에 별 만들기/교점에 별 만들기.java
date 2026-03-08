import java.util.*;

class Solution {

    public String[] solution(int[][] line) {

        Set<String> stars = new HashSet<>();

        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++){

                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long parent = a*d - b*c;
                if(parent == 0) continue;

                long xChild = b*f - e*d;
                long yChild = e*c - a*f;

                if(xChild % parent != 0 || yChild % parent != 0) continue;

                long x = xChild / parent;
                long y = yChild / parent;

                stars.add(x + "," + y);

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        int height = (int)(maxY - minY + 1);
        String[] answer = new String[height];

        for(int i = 0; i < height; i++){

            long y = maxY - i;
            StringBuilder sb = new StringBuilder();

            for(long x = minX; x <= maxX; x++){
                if(stars.contains(x + "," + y)) sb.append('*');
                else sb.append('.');
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}