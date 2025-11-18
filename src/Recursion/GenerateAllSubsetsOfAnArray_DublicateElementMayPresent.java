package Recursion;
import java.util.*;
// lecture : Recursion part 3 . Prob 2 soln :

// LeetCode - Subsets II (handles duplicates)
// Returns all possible subsets (the power set) without duplicate subsets.
/*
Que :
Given an integer array nums that " may contain duplicates ", return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

 */

public class GenerateAllSubsetsOfAnArray_DublicateElementMayPresent {

        public List<List<Integer>> subsetsWithDup(int[] arr) {
            List<List<Integer>> allsubsets = new ArrayList<>();

            Arrays.sort(arr); //  step 1 Sort the array

            printSubsets(arr, new ArrayList<>(), 0, allsubsets);
            return allsubsets;
        }

        private void printSubsets(int[] arr, List<Integer> ans, int i, List<List<Integer>> allsubsets) {

            if (i == arr.length) {
                allsubsets.add(new ArrayList<>(ans));
                return;
            }

            ans.add(arr[i]);     // include arr[i]
            printSubsets(arr, ans, i + 1, allsubsets);

            // Backtrack
            ans.remove(ans.size() - 1);         // backtrack ke baad

            // skip duplicates
            int idx = i + 1;
            while (idx < arr.length && arr[idx] == arr[idx - 1]) {
                idx++;
            }

            // exclude arr[i]
            printSubsets(arr, ans, idx, allsubsets);
        }
}
