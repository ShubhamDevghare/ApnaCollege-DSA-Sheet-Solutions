package StriverDSA_DynamicPrograming;

import java.util.*;
/*
Ninja is planning this ‘N’ days-long training schedule.
Each day, he can perform any one of these three activities: Running, Fighting Practice or Learning New Moves.
Each activity has some merit points on each day.
As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity.
Your task is to calculate the maximum number of merit points that Ninja can earn.
 */
/*
🥷 Problem in simple words
===========================
Ninja trains for N days
Each day he can do one of 3 activities:
0 → Running
1 → Fighting Practice
2 → Learning New Moves
points[day][activity] gives merit points
Constraint: He cannot repeat the same activity on two consecutive days
Goal: maximize total merit points
 */
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
