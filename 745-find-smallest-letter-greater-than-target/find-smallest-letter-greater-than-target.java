class Solution {
    public char nextGreatestLetter(char[] arr, char x) {
        int s=0;
        int e=arr.length-1;
        if(x>=arr[arr.length-1]){
            return arr[0];
        }
        char ans='a';
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]>x){
                ans=arr[mid];
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}