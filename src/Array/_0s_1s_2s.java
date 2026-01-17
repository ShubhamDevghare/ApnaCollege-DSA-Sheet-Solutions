package Array;
/*
Sort Colors
===========
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
----------------------------------------------------------------------

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

 */
/*
💡Key Idea (Dutch National Flag Algorithm)
---------------------------------------------

Maintain three pointers:
------------------------
low → boundary for 0s (red)
mid → current element being examined
high → boundary for 2s (blue)

Invariant during iteration:
--------------------------
nums[0 .. low-1] → all 0s
nums[low .. mid-1] → all 1s
nums[mid .. high] → unknown
nums[high+1 .. n-1] → all 2s


Algorithm Steps
---------------
While mid <= high:

If nums[mid] == 0
Swap nums[mid] and nums[low]
Increment both low and mid

If nums[mid] == 1
Just move mid

If nums[mid] == 2
Swap nums[mid] and nums[high]
Decrement high
Do NOT increment mid (the swapped value must be checked)
 */
public class _0s_1s_2s {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

