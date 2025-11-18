package Recursion;

public class RecursiveBinarySearch {

    // Recursive Binary Search
    public static int binarySearch(int[] arr, int target, int low, int high) {

        if (low > high) return -1; // base case: not found

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid; // element found
        else if (arr[mid] > target) return binarySearch(arr, target, low, mid - 1);
        else return binarySearch(arr, target, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        int result = binarySearch(arr, target, 0, arr.length - 1);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(log n) due to recursion stack
