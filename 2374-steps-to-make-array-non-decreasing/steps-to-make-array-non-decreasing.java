class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int res = 0;
        // stack stores pair: [value, steps]
        Deque<int[]> stack = new ArrayDeque<>();
        
        for(int i = n - 1; i >= 0; i--) {
            int steps = 0;
            while(!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                steps = Math.max(steps + 1, stack.peek()[1]);
                stack.pop();
            }
            res = Math.max(res, steps);
            stack.push(new int[]{nums[i], steps});
        }
        
        return res;
    }
}
