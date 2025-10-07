class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }
        
        // Sort by nums
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Find total cost weight
        long totalCost = 0;
        for (int[] a : arr) totalCost += a[1];
        
        // Find weighted median
        long half = (totalCost + 1) / 2;
        long cur = 0;
        int median = 0;
        for (int[] a : arr) {
            cur += a[1];
            if (cur >= half) {
                median = a[0];
                break;
            }
        }
        
        // Calculate minimum total cost using that median
        long ans = 0;
        for (int[] a : arr) {
            ans += 1L * Math.abs(a[0] - median) * a[1];
        }
        return ans;
    }
    
}