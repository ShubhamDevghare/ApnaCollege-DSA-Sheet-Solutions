package Recursion;
// // lecture : Recursion part 1 . Prob 1 soln :
public class PrintNumbers {

    // Print numbers from 1 to n using recursion
    public static void print(int n) {
        if (n == 0) return; // base case

        print(n - 1); // recursive call

        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 10; // example
        print(n);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack
