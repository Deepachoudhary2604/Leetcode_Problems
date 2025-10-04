class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr=new int[9];
        for(int i=1;i<=9;i++){
            arr[i-1]=i;
        }
        List<List<Integer>> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        solve(arr,k,n,0,ans1,ans2);
        return ans1;
    }
    public static void solve(int[] arr,int k,int n,int idx,List<List<Integer>> ans1,List<Integer> ans2){
        if(k==0 && n==0){
            ans1.add(new ArrayList<>(ans2));
            return;
        }
        if(idx==arr.length){
            return;
        }
        if(k==0 || n==0){
            return;
        }
        ans2.add(arr[idx]);
        solve(arr,k-1,n-arr[idx],idx+1,ans1,ans2);
        ans2.remove(ans2.size()-1);

        solve(arr,k,n,idx+1,ans1,ans2);
    }
}