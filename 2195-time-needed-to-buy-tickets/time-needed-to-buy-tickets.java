class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            q.add(i);
        }
        int time=0;
        while(arr[k]!=0){
            arr[q.peek()]--;
            if(arr[q.peek()]!=0){
                q.add(q.peek());
            }
            time++;
            q.poll();
        }
        return time;
    }
}