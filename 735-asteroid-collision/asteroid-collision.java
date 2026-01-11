class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            int val2 = asteroids[i];

            // 🔹 CHANGE 1: while loop + correct collision condition
            while (!st.isEmpty() && st.peek() > 0 && val2 < 0) {
                int val1 = st.peek();

                // 🔹 CHANGE 2: handle sizes correctly
                if (Math.abs(val1) < Math.abs(val2)) {
                    st.pop();
                }
                else if (Math.abs(val1) == Math.abs(val2)) {
                    st.pop();
                    val2 = 0;   // both destroyed
                    break;
                }
                else {
                    val2 = 0;   // current destroyed
                    break;
                }
            }

            // 🔹 CHANGE 3: push only if alive
            if (val2 != 0) {
                st.push(val2);
            }
        }

        int[] adj = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            adj[i] = st.pop();
        }
        return adj;
    }
}
