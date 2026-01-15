package Array;
/*
Pow(x, n)
=============
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

 */

/*

Basic :
N = Power

1. if n is Negative: x⁻ⁿ = 1 / xⁿ

2. If n is even:   xⁿ = (x²)^(n/2)

3. If n is odd:     xⁿ = x × (x²)^((n-1)/2)

This reduces time complexity from O(n) to O(log n).

What is Binary Exponentiation?
==============================

x^N
---

Instead of multiplying x,  N times, we:
square the number
divide the power by 2 each time

That’s why it’s fast.

i.e

Example: 2¹⁰
-------------

10 is even → square
2¹⁰ = (2²)⁵

5 is odd → take one 2
2⁵ = 2 × (2²)²

2² = 4
4² = 16

Final:

2 × 16 × 16 = 1024

 */

public class Pow_xn {

    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {
            if (N % 2 == 1) {   // odd
                result = result * x;
            }
            x = x * x;         // square
            N = N / 2;         // reduce power
        }

        return result;
    }
}
