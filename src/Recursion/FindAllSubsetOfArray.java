package Recursion;
import java.util.*;
// lecture : Recursion part 3 . Prob 1 soln :
/*
Leetcode Prob no 78.
Que :
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

 */

public class FindAllSubsetOfArray {

    static void printSubsets(int[] arr, List<Integer> ans, int i) {
        // Base case
        if (i == arr.length) {
            System.out.println(ans);
            return;
        }

        // Include the current element
        ans.add(arr[i]);
        printSubsets(arr, ans, i + 1);

        // Backtrack
        ans.remove(ans.size() - 1);

        // Exclude the current element
        printSubsets(arr, ans, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> ans = new ArrayList<>();

        printSubsets(arr, ans, 0);
    }
}
