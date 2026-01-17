package Array;
/*
Search a 2D Matrix
--------------------
You are given an m x n integer matrix with the following two properties:

- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */
/*
Basic :
======
In binary search, you never scan one by one.
You always jump to the middle, check it, and throw away half the data.

Smallest possible example (array)
Imagine this array:

Index: 0  1  2  3  4
Value: 1  3  5  7  9

Step 1:

left = 0
right = 4
mid = (left + right) / 2 = 2

mid = 2 → value is 5

You compare:
- target < 5 → search left half
- target > 5 → search right half

*/
/*
💡Key Idea
------------

Given:
- Rows are sorted.
- First element of each row > last element of previous row.
So the matrix behaves like:

[ row0..., row1..., row2..., ... ]

Index mapping:

1D index → 2D position

-    row = mid / n
-    col = mid % n
                      Where n is the number of columns.

This allows O(log(m × n)) time using binary search.

 */

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
/*
Algorithm
----------

- Let m = number of rows
      n = number of columns

- Binary search range:
      left = 0,
      right = m * n - 1

- While left <= right:

      mid = left + (right - left) / 2

      Convert:
             row = mid / n
             col = mid % n

Compare matrix[row][col] with target
Return true if found, otherwise false
 */