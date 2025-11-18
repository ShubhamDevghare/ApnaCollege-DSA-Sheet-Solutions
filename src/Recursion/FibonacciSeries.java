package Recursion;

public class FibonacciSeries {

    public static void printFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    // Recursive Fibonacci calculation
    public static int fib(int n) {
        if (n == 0) return 0; // base case
        if (n == 1) return 1; // base case
        return fib(n - 1) + fib(n - 2); // recursive relation
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacci(n);
    }
}

/*
Time Complexity: O(2^n)
Space Complexity: O(n)
*/