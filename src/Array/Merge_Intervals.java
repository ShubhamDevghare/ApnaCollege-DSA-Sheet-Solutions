package Array;
/*
Pre-requisites : Sorting

Merge_Intervals
==============
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

 */

/*
Note 1 :
-------
In Java, the ArrayList.get() method is used to retrieve the element at a specified position (index) in an ArrayList.
It takes an integer index as an argument and returns the element stored at that index.

        listOfArrays { {10, 20},{30, 40},{50, 60} }

        // Get the last array (which is {50, 60})
        Integer[] lastArray = listOfArrays.get(listOfArrays.size() - 1);

        // Get the second element (at index 1) of that last array
        Integer value = lastArray[1]; // This is 60
 */

import java.util.*;
public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // 2. If list is empty or no overlap, add interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            }
            // 3. Overlap detected, merge intervals
            else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
