class Solution {
    public long subArrayRanges(int[] nums) {
       return subArrayMaxs(nums)-subArrayMins(nums);
    }
    public long subArrayMins(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];
        int[] nle = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            sum += arr[i] * left * right;
        }

        return sum;
    }
    public long subArrayMaxs(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += arr[i] * left * right;
        }

        return sum;
    }
}

