class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int[] ans=new int[set.size()];
        int j=0;
        for(int i:set){
            ans[j]=i;
            j++;
        }
        Arrays.sort(ans);
        int[] rank=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            rank[i]=Arrays.binarySearch(ans,arr[i])+1;
        }
        return rank;
    }
}