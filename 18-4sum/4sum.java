import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n - 3; i++) {

            for (int j = i + 1; j < n - 2; j++) {

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {

                        List<Integer> temp = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        );

                        set.add(temp);

                        k++;
                        l--;
                    }
                    else if (sum < target) {
                        k++;
                    }
                    else {
                        l--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}