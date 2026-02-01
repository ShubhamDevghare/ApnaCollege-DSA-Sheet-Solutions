package StriverDSA_DynamicPrograming;

import java.util.*;

public class NinjaTraining {

    // Recursive function to calculate the maximum points
    static int f(int day, int last, int[][] points, int[][] dp) {

        // If already computed, return it
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        // Base case: day 0
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;

        // Try all activities except the last one
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }

        return dp[day][last] = maxi;
    }

    // Function to find maximum points
    static int ninjaTraining(int n, int[][] points) {

        int[][] dp = new int[n][4];

        // Initialize dp with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from last day, with no previous activity (3)
        return f(n - 1, 3, points, dp);
    }

    public static void main(String[] args) {

        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
