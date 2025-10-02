class Solution {
    static final int d = 256;
    static final int mod = 1_000_000_007;

    public int strStr(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        if (m == 0) return 0;
        if (n < m) return -1;

        long p = 0, t = 0, h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % mod;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % mod;
            t = (d * t + txt.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) return i;
            }
            if (i < n - m) {
                t = (d * (t - (long)txt.charAt(i) * h) + txt.charAt(i + m)) % mod;
                if (t < 0) t += mod;
            }
        }

        return -1;
    }
}
