// class Solution {
//     public int maxProduct(int[] nums) {
//         int maxi=Integer.MIN_VALUE;
//         int prod=1;
//         for(int i=0;i<nums.length;i++){
//             prod=Math.max(nums[i],prod*nums[i]);
//             maxi=Math.max(maxi,prod);
//         }
//         if(maxi==1){
//             return 0;
//         }
//         return maxi;
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}