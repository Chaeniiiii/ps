class Solution {
    public long solution(int w, int h) {
        long width = (long) w;
        long height = (long) h;

        return width * height - (width + height - gcd(width, height));
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
