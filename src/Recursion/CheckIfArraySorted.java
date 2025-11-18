package Recursion;

public class CheckIfArraySorted {

    public static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true; // base case

        if (arr[index] > arr[index + 1]) return false; // violation

        return isSorted(arr, index + 1); // recursive call
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // example
        boolean sorted = isSorted(arr, 0);
        System.out.println("Array Sorted? " + sorted);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack
