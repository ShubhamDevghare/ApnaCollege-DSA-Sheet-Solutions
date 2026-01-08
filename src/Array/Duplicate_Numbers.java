package Array;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
         --------------------------------
You must solve the problem without modifying the array nums and using only constant extra space.
                            ---------------------------------------------------------------------
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */

/*
Pre-requisite: LL Cycles
You should already understand Linked List cycle detection
(especially Floyd’s Tortoise and Hare algorithm) before solving this problem.
LL = Linked List
A cycle in a linked list happens when:
A node’s next pointer points to a previous node
This causes an infinite loop

Example :
1 → 2 → 3 → 4 → 5
          ↑     ↓
          ← ← ←

Why is it a Pre-requisite for This Problem?
In the Find Duplicate Number problem:
nums = [1,3,4,2,2]

We Imagine the array like a linked list:
Index = node
Value = next pointer

Index:  0  1  2  3  4
Value: [1, 3, 4, 2, 2]

0 → 1 → 3 → 2 → 4
          ↑     ↓
          ← ← ←

⚠️ Because one number is duplicated, two indices point to the same value, creating a cycle.
👉 Finding the entry point of the cycle = duplicate number

🔹 Floyd’s Cycle Detection (Core Idea)
========================================

Two pointers:

slow → moves 1 step
fast → moves 2 steps

If a cycle exists:
- slow and fast will meet
- Reset one pointer to start
- Move both 1 step
- Meeting point = cycle entry
 */

/*
We Imagine the array like a linked list:
Index = node
Value = next pointer    // why?? bcz it is obviously that if number is repeated/duplicate then always atleast one infiniate loop form there. or we can say that two pointer(slow and fast) will meet at same position

 */
public class Duplicate_Numbers {

    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];          // means move by +1 in context of linked list
            fast = nums[nums[fast]];    // means move by +2 in context of linked list
        } while (slow != fast);

        // Phase 2: Find entrance to cycle
        slow = nums[0];     // while keeping the positon of fast as it is  changing the positon of slow to 0th postion .ie starting pt.
        while (slow != fast) {
            slow = nums[slow];   // means move by +1 in context of linked list
            fast = nums[fast];   // means move by +1 in context of linked list
        }

        return slow;
    }

}  // TC : O(n)
   // SC : O(1)


/*
class Solution {
    public int findDuplicate(int[] nums) {
         Arrays.sort(nums); // why not used ths approach bcz her we are doing modification in Arrays and in Qus said that we dont have to modify the Array
        for (int  i = 1 ; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
             return -1;
    }
}
 */
