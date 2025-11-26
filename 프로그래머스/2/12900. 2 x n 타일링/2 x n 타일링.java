class Solution {

    private static final int MAX = 1_000_000_007;
    
    public int solution(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int fib = (a + b) % MAX;
            a = b;
            b = fib;
        }
        return b;
    }

}
