class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums1)
            for(int l : nums2)
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
        int count = 0;
        for(int i : nums3)
            for(int j : nums4)
                        count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}