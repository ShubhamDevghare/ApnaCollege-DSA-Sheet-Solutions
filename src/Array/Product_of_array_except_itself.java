package Array;
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of
all the elements of nums except nums[i].

-The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
-You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 */

/*

💡 Key Idea
-------------
For each index i:
answer[i] = (product of elements to the left of i)
          * (product of elements to the right of i)

We compute this in two passes:
Left pass → store prefix products
Right pass → multiply suffix products into the same array
 */

/*
Algorithm
---------
Initialize answer array with 1s.

- Traverse from left to right:
     answer[i] = product of all elements before i
- Traverse from right to left:
     Multiply answer[i] by product of all elements after i
 */
public class Product_of_array_except_itself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}

