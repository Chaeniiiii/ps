import java.util.*;

class Solution {
    public int solution(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        
        int sum1 = Integer.parseInt(sb.toString());
        int sum2 = a * b * 2;
        
        return Math.max(sum1,sum2);
    }
}