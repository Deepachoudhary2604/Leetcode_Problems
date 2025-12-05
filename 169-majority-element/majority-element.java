class Solution {
    public int majorityElement(int[] arr) {
        int val=arr[0];
        int c=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val){
                c++;
            }
            else{
                c--;
                if(c==0){
                    val=arr[i];
                    c=1;
                }
            }
        }
        return val;
    }
}
