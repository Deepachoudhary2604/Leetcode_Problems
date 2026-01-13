class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    List<Integer> adj=new ArrayList<>();
                    adj.add(nums[i]);
                    adj.add(nums[j]);
                    adj.add(nums[k]);
                    j++;
                    k--;
                    if(!set.contains(new ArrayList<>(adj))){
                        set.add(new ArrayList<>(adj));
                        ans.add(new ArrayList<>(adj));
                    }
                    
                }
                
            }
        }
        return ans;
    }
}
