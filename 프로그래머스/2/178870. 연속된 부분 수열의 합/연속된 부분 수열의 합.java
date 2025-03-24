import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];
        
        int left = 0, right = 0, sum = 0, minLen =  Integer.MAX_VALUE;
        while (right < sequence.length) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left++];
            }

            if (sum == k) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            right++;
        }

        return answer;
    }
}
