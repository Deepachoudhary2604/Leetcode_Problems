class Solution {
    public void sortColors(int[] arr) {
        int one=0;
        int zero=0;
        int two=0;
        for(int i:arr){
            if(i==0){
                zero++;
            }
            if(i==1){
                one++;
            }
            if(i==2){
                two++;
            }
        }
        int k=0;
        for(int i=0;i<zero;i++){
            arr[k]=0;
            k++;
        }
        for(int i=0;i<one;i++){
            arr[k]=1;
            k++;
        }
        for(int i=0;i<two;i++){
            arr[k]=2;
            k++;
        }
    }
}