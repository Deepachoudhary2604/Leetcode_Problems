class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> l1=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    long total=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(total>target){
                        l--;
                    }
                    else if(total<target){
                        k++;
                    }
                    else{
                        ArrayList<Integer> l2=new ArrayList<>();
                        l2.add(nums[i]);
                        l2.add(nums[j]);
                        l2.add(nums[k]);
                        l2.add(nums[l]);
                        l1.add(new ArrayList<>(l2));
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                        while(k<l && nums[l]==nums[l+1]){
                            l--;
                        }
                    }
                }
            }
        }
        return l1;
    }
}