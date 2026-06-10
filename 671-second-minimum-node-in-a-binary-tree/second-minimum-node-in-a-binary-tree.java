class Solution {
    public void pre(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        pre(root.left, ans);
        pre(root.right, ans);
    }

    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        pre(root, ans);

        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) < min1) {
                min2 = min1;
                min1 = ans.get(i);
            } 
            else if (ans.get(i) > min1 && ans.get(i) < min2) {
                min2 = ans.get(i);
            }
        }

        if (min2 == Long.MAX_VALUE) {
            return -1;
        }

        return (int) min2;
    }
}