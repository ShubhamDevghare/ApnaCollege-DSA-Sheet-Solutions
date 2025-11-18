package Recursion;
// lecture : Recursion part 1 . Prob 3 soln :

public class Factorial {

    // Recursively calculate factorial of n
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1; // base case
        return n * factorial(n - 1);   // recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.println("Factorial = " + result);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack
