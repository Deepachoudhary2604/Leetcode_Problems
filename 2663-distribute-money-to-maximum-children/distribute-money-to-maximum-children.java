class Solution {
    public int distMoney(int money, int children) {
        if (money < children) return -1;

        money -= children;

        int ans = Math.min(money / 7, children);

        if (ans == children && money - ans * 7 > 0) {
            ans--;
        }

        if (money - ans * 7 == 3 && ans == children - 1) {
            ans--;
        }

        return ans;
    }
}