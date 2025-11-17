package BinarySearch;
import java.util.Arrays;

public class BookAllocationProblem {

    /**
     * Helper function to check if it's possible to allocate all books such that
     * no student receives more than maxAllowedPages, using at most 'm' students.
     * @param arr The array of book pages.
     * @param n The number of books (length of arr).
     * @param m The number of students.
     * @param maxAllowedPages The maximum number of pages a student can be allocated (the 'mid' value).
     * @return true if a valid allocation is possible, false otherwise.
     */

    // 3. Logic for validating
    public static boolean isValid(int[] arr, int n, int m, long maxAllowedPages) {

        // Greedy allocation: try to give contiguous books to each student without exceeding maxAllowedPages.
        int students = 1;
        long pages = 0;

        for (int i = 0; i < n; i++) {
            // If a single book has more pages than maxAllowedPages, it's impossible.
            if (arr[i] > maxAllowedPages) return false;

            if (pages + arr[i] <= maxAllowedPages) {
                pages += arr[i];
            } else {
                // allocate to next student
                students++;
                pages = arr[i];
                if (students > m) return false;
            }
        }

        return true;
    }

    public static long allocateBooks(int[] arr, int n, int m) {

        if (m > n) return -1;

// 1. Defining/Finding Search Space i.e Range
        long sum = 0;
        int maxBook = Integer.MIN_VALUE;
        for (int page : arr) {
            sum += page;
            maxBook = Math.max(maxBook, page);
        }

        long start = maxBook; // minimum possible maximum (largest single book)
        long end = sum;       // maximum possible maximum (all books to one student)
        long ans = -1;
// 2. Binary Search :
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isValid(arr, n, m, mid)) {
                ans = mid;
                end = mid - 1; // try smaller
            } else {
                start = mid + 1; // need larger limit
            }
        }

        return ans;
    }

    // Example / quick test
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println(allocateBooks(books, books.length, students)); // Expected: 113
    }
}