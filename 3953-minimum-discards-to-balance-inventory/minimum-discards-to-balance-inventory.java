class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int arr[]=new int[100001];
        int l=0,r=0;
        int n=arrivals.length;
        int discard=0;
        Set<Integer>set=new HashSet<>();
        while(r<n){
            arr[arrivals[r]]++;
            if(arr[arrivals[r]]>m){
                discard++; arr[arrivals[r]]--;set.add(r);
            }
           if(r-l+1==w){
               if(!set.contains(l)) arr[arrivals[l]]--;
            l++;
        }
            r++;
        }
        return discard;
    }
}