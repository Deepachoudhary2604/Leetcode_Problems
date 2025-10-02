class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum_gas=0;
        int sum_cost=0;
        for(int i=0;i<gas.length;i++){
            sum_gas+=gas[i];
            sum_cost+=cost[i];
        }
        if(sum_cost>sum_gas){
            return -1;
        }
        int start=0;
        int totalTank=0;
        int currTank=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            totalTank+=diff;
            currTank+=diff;
            if(currTank<0){
                currTank=0;
                start=i+1;
            }
        }
        if(totalTank>=0){
            return start;
        }
        return -1;
    }
}