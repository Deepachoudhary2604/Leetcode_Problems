class Solution {
    public int minOperations(int[] nums) {
        int k=3;
        int n=nums.length;
        Queue<Integer> q=new LinkedList<>();
        int flip=0;
        for(int i=0;i<nums.length;i++){
            if(!q.isEmpty() && q.peek()==i){
                q.poll();
            }
            int curr=nums[i];
            if(q.size()%2==1){
                curr=1-curr;
            }
            if(curr==0){
                if(i+k>n){
                    return -1;
                }
                flip++;
                q.add(i+k);
            }
        }
        return flip;
    }
}