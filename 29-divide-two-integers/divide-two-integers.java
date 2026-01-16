class Solution {

    public int divide(int dividend, int divisor) {

        // ONLY overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ans = 0;

        while (a >= b) {
            int c = 0;
            while (a >= (b << (c + 1))) {
                c++;
            }
            ans += (1 << c);
            a -= (b << c);
        }

        return negative ? -ans : ans;
    }
}
