class Solution {
    public int splitArray(int[] arr, int k) {
        int s=0;
        int e=0;
        for(int i:arr){
            s=Math.max(i,s);
            e+=i;
        }
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int pages=0;
            int c=1;
            for(int i=0;i<arr.length;i++){
                pages+=arr[i];
                if(pages>mid){
                    c++;
                    pages=arr[i];
                }
            }
            if(c<=k){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}