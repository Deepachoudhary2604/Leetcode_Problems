class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans1=new ArrayList<>();
        permutation(nums,ans1,0);
        return ans1;
    }
    public void permutation(int[] nums,List<List<Integer>> ans1,int idx){
        if(idx==nums.length){
            List<Integer> l1=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                l1.add(nums[i]);
            }
            ans1.add(l1);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            permutation(nums,ans1,idx+1);
            swap(nums,i,idx);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}