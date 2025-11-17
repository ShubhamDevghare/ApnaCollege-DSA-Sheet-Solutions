package BinarySearch;
/*
Que :: You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

 */
public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int st = 1, end = A.length - 2;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) { //  check whether mid is peak
                return mid;

            } else if (A[mid - 1] < A[mid]) { // right
                st = mid + 1;

            } else { // left
                end = mid - 1;
            }
        }
        return -1;
    }
}
