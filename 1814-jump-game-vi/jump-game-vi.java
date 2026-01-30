class Solution {
    public int maxResult(int[] nums, int k) {

        int n = nums.length;

        // max heap -> stores {index , dpValue}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1] - a[1]
        );

        pq.offer(new int[]{0, nums[0]});

        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i = 1; i < n; i++){

            // remove out of range
            while(!pq.isEmpty() && i - pq.peek()[0] > k){
                pq.poll();
            }

            dp[i] = nums[i] + pq.peek()[1];

            pq.offer(new int[]{i, dp[i]});
        }

        return dp[n-1];
    }
}
