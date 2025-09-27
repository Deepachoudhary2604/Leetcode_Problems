class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                if(sum>0){
                    k--;
                }
                if(sum==0){
                    ArrayList<Integer> arr=new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    ans.add(arr);
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    // Skip duplicates for k
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
