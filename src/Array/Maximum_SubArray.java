package Array;
/*
Maximum Subarray (Kadane’s Algorithm)
====================================

Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Key Idea (Kadane’s Algorithm)
-----------------------------
As you scan the array, at each index decide:

Extend the previous subarray, OR
Start fresh from the current element

If the running sum ever becomes negative, it can only hurt future sums—so reset it.

Algorithm Steps
---------------
Initialize:
currentSum = nums[0]
maxSum = nums[0]

For each element from index 1 to n-1:

currentSum = max(nums[i], currentSum + nums[i])

maxSum = max(maxSum, currentSum)

Return maxSum
 */

public class Maximum_SubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

