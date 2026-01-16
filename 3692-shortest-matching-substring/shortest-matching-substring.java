class Solution {
    public int shortestMatchingSubstring(String s, String p) {

        String[] parts = p.split("\\*", -1);
        String A = parts[0], B = parts[1], C = parts[2];

        int n = s.length();
        int ans = Integer.MAX_VALUE;

        // nextB[i] = earliest index >= i where B starts
        // nextC[i] = earliest index >= i where C starts
        int[] nextB = new int[n + 1];
        int[] nextC = new int[n + 1];

        // initialize with -1
        for (int i = 0; i <= n; i++) {
            nextB[i] = -1;
            nextC[i] = -1;
        }

        // build nextB
        for (int i = n - B.length(); i >= 0; i--) {
            if (s.startsWith(B, i)) nextB[i] = i;
            else nextB[i] = nextB[i + 1];
        }

        // build nextC
        for (int i = n - C.length(); i >= 0; i--) {
            if (s.startsWith(C, i)) nextC[i] = i;
            else nextC[i] = nextC[i + 1];
        }

        // try all positions of A
        for (int i = 0; i + A.length() <= n; i++) {
            if (!s.startsWith(A, i)) continue;

            int posB = nextB[i + A.length()];
            if (posB == -1) continue;

            int posC = nextC[posB + B.length()];
            if (posC == -1) continue;

            ans = Math.min(ans, posC + C.length() - i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
