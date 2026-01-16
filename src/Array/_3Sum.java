package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Note : The solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].

Note:The order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

 */
/*
💡 Key Idea (Optimal Approach)
-------------------------------
Sort + Two Pointers (j , k)
---------------------------
eg : -1 -4 0  2  1  -1
1. Sort the array                   -4 -1 -1 0 1 2

                                   - Helps avoid duplicates
                                   - Allows efficient two-pointer scanning

2. Fix one number (i)              -4 -1 -1 0 1 2
   i --> 1 to n                     i  j        k

   j = i + 1
   k = n - 1

while( j < K )                     bcz : i!=j!=k  therefore j != K
   find sum ,  nums[i] + nums[j] + nums[k] = 0
if,
sum < 0 , Move j++
sum > 0 , move i++

Perfect Case : sum == 0
end.

4. Skip duplicates , With sorted data me get repeated value ,   -4 -1 -1 0 1 2
                                                                   == ===
                                                                       i
    2 Optimization :
    - Skip duplicate values for i                              if ( i>0 && nums[i] == nums (i-1) ) continue;

    - Skip duplicate values for j and k
 */
public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            //Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicate values for j and k
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {      // to make sum to reach sum == 0 whe have to move j and k : if, sum < 0 , Move j++  else if sum > 0 , move k++
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
