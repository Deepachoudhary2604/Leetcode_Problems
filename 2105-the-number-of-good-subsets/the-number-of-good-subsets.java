class Solution {
    static final int MOD = 1_000_000_007;
    int[] primes = {2,3,5,7,11,13,17,19,23,29};

    public int numberOfGoodSubsets(int[] nums) {
        int[] cnt = new int[31];
        for (int x : nums) cnt[x]++;

        int[] mask = new int[31];
        for (int i = 2; i <= 30; i++) {
            int x = i, m = 0;
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                int p = primes[j];
                if (x % p == 0) {
                    x /= p;
                    if (x % p == 0) { // square factor
                        ok = false;
                        break;
                    }
                    m |= (1 << j);
                }
            }
            mask[i] = ok ? m : -1;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int i = 2; i <= 30; i++) {
            if (cnt[i] == 0 || mask[i] == -1) continue;
            for (int s = (1 << 10) - 1; s >= 0; s--) {
                if ((s & mask[i]) == 0) {
                    dp[s | mask[i]] = (dp[s | mask[i]] + dp[s] * cnt[i]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int s = 1; s < (1 << 10); s++) ans = (ans + dp[s]) % MOD;

        long pow = 1;
        for (int i = 0; i < cnt[1]; i++) pow = (pow * 2) % MOD;

        return (int)(ans * pow % MOD);
    }
}
