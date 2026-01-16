package Array;
/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
---------
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
---------
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
-----------
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

 */
/*
💡 Key Idea (Optimal Approach)  Two Pointers (p , q) Approch
-------------------------------

1. Sort the array    Sorting allows:      - Efficient duplicate elimination
                                          - Two-pointer technique for the remaining two numbers

2. Fix the first two numbers (i, j)
       - Use two loops
       - Skip duplicates to ensure uniqueness

3. Use two pointers (p, q)
       - Move inward based on comparison with target
       - Skip duplicates after finding a valid quadruplet
 */

import java.util.*;

public class _4Sum  {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            if (n < 4) return ans;

            Arrays.sort(nums);

            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

                for (int j = i + 1; j < n - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates

                    int p = j + 1;
                    int q = n - 1;

                    while (p < q) {
                        long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                        if (sum == target) {
                            ans.add(Arrays.asList(
                                    nums[i], nums[j], nums[p], nums[q]
                            ));

                            p++;
                            q--;

                            while (p < q && nums[p] == nums[p - 1]) p++;
                            while (p < q && nums[q] == nums[q + 1]) q--;

                        } else if (sum < target) {
                            p++;
                        } else {
                            q--;
                        }
                    }
                }
            }
            return ans;
        }
    }
