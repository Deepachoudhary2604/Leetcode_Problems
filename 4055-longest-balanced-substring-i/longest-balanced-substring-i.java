class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch=s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (isBalanced(map)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    private boolean isBalanced(HashMap<Character, Integer> map) {
        int target = -1;
        for (int count: map.values()) {
            if (target==-1) target = count;
            else if (count != target) return false;
        }
        return true;
    }
}