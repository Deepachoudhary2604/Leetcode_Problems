class Solution {
    public int[] singleNumber(int[] nums) {
        int ans1 = 0;
        int ans2 = 0;
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        // FIX
        int maskBit = xor & -xor;

        for (int num : nums) {
            if ((num & maskBit) == 0) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }

        return new int[]{ans1, ans2};
    }
}
