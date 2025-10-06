class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return solve(s, p, s.length() - 1, p.length() - 1, dp);
    }

    public boolean solve(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = solve(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            ans = solve(s, p, i, j - 1, dp) || solve(s, p, i - 1, j, dp);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
