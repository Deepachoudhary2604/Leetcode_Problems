class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalWeight = 0;
        int currentSum = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int weight = gas[i] - cost[i];
            totalWeight += weight;
            currentSum += weight;

            if (currentSum < 0) {
                start = i + 1;
                currentSum = 0;
            }
        }

        return totalWeight < 0 ? -1 : start;
        
    }
}