package Recursion;
//  lecture : Recursion part 1 . Prob 2 soln :

public class SumOfNaturalNumber {

    public static int sum(int n) {
        if (n == 0) return 0; // base case

        return n + sum(n - 1); // recursive step
    }

    public static void main(String[] args) {
        int n = 10;
        int result = sum(n);
        System.out.println("Sum = " + result);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack
