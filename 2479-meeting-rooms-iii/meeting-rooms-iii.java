import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i = 0; i < n; i++) free.add(i);

        // {endTime, roomIndex}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for(int i = 0; i < meetings.length; i++){
            long start = meetings[i][0];
            long end = meetings[i][1];
            long duration = end - start;

            while(!busy.isEmpty() && busy.peek()[0] <= start){
                free.add((int)busy.poll()[1]);
            }

            if(!free.isEmpty()){
                int room = free.poll();
                count[room]++;
                busy.add(new long[]{end, room});
            }
            else{
                long[] val = busy.poll();
                int room = (int) val[1];
                long newEnd = val[0] + duration;
                count[room]++;
                busy.add(new long[]{newEnd, room});
            }
        }

        int ans = 0;
        for(int i = 1; i < n; i++){
            if(count[i] > count[ans]){
                ans = i;
            }
        }
        return ans;
    }
}
