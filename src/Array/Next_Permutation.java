package Array;
/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.


Example 1:
----------
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
---------
Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Constraints:
------------
1 <= nums.length <= 100
0 <= nums[i] <= 100

 */
/*
What does “next permutation” REALLY mean?
-----------------------------------------
Think of permutations like dictionary order.
For numbers [1,2,3], the order is:

123
132  ← next
213
231
312
321

So “next permutation” means
👉 the next bigger number you can make using the same digits.

 */

/*

A = [1,2,5,4,3]  -->  13542  --> 13245
       P               P          P

One-Line Memory Trick (VERY USEFUL)
-----------------------------------
Scan(Right to Left) to find pivot → Swap → Reverse

i.e,

1.find the pivot => A[i] >= A[i=1]
2.find the Right most element > Pivot  then swap(Right most element , Pivot)
3.Reverse (pivot + 1) to (n-1)

 */
public class Next_Permutation {

        public void nextPermutation(int[] nums) {
            int n = nums.length;

            // ---------- STEP 1: Find pivot ----------
            int pivot = -1;
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    pivot = i;
                    break;
                }
            }

            // ---------- STEP 2: If no pivot, reverse whole array ----------
            if (pivot == -1) {
                reverse(nums, 0, n - 1);
                return;
            }

            // ---------- STEP 3: Find next greater element & swap ----------
            for (int i = n - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    swap(nums, i, pivot);
                    break;
                }
            }

            // ---------- STEP 4: Reverse suffix ----------
            reverse(nums, pivot + 1, n - 1);
        }

        // Helper: swap two elements
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Helper: reverse array from left to right
        private void reverse(int[] nums, int left, int right) {
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
