class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long s = 1; // minimum possible time
        long e = (long) Arrays.stream(time).min().getAsInt() * totalTrips; // max possible time

        while (s < e) {
            long mid = s + (e - s) / 2;
            long trips = 0;

            for (int t : time) {
                trips += mid / t;
            }

            if (trips >= totalTrips) {
                e = mid; // try smaller time
            } else {
                s = mid + 1; // need more time
            }
        }

        return s;
    }
}
