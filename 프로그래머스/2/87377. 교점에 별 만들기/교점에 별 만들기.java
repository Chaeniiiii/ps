import java.util.*;

class Solution {
    
    private static class Pos {
        long y;
        long x;
        
        private Pos(long y, long x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public String[] solution(int[][] line) {
        
        ArrayList<Pos> arr = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for (int i = 0; i < line.length; i++) {
            int[] m1 = line[i];
            long A = m1[0];
            long B = m1[1];
            long E = m1[2];
            
            for (int j = i + 1; j < line.length; j++) {
                int[] m2 = line[j];
                long C = m2[0];
                long D = m2[1];
                long F = m2[2];
                
                long adbc = A * D - B * C;
                if (adbc == 0) continue;
                
                double x = (double)(B * F - E * D) / adbc;
                double y = (double)(E * C - A * F) / adbc;
                
                if (x % 1 != 0 || y % 1 != 0) continue;
                
                long nx = (long)x;
                long ny = (long)y;
                
                arr.add(new Pos(ny, nx));
                
                minX = Math.min(minX, nx);
                minY = Math.min(minY, ny);
                maxX = Math.max(maxX, nx);
                maxY = Math.max(maxY, ny);
            }
        }
        
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        
        String[][] str = new String[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(str[i], ".");
        }

        for (Pos pos : arr) {
            int x = (int)(pos.x - minX);
            int y = (int)(maxY - pos.y); 
            str[y][x] = "*";
        }

        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = String.join("", str[i]);
        }
        
        return result;
    }
}
