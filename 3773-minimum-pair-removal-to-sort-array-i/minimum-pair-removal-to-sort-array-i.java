class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> adj = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            adj.add(nums[i]);
        }

        if(sorted(adj)){
            return 0;
        } 
        int c=0;
        while(!sorted(adj)) {
            int min=Integer.MAX_VALUE;
            int pos=0;
            for (int i = 1; i < adj.size(); i++) {
                int sum=adj.get(i-1)+adj.get(i);
                if (sum<min) {
                    min=sum;
                    pos=i-1;
                }
            }
            adj.remove(pos+1);
            adj.remove(pos);
            adj.add(pos,min);
            c++;
        }
        return c;
    }

    public boolean sorted(ArrayList<Integer> nums) {
        for (int i=1; i<nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                return false;
            }
        }
        return true;
    }
}
