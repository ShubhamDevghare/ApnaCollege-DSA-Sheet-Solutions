package BinarySearch;
/*
Que :: You are given an array with unique elements of stalls[], which denote the positions of stalls.
You are also given an integer k which denotes the number of aggressive cows.
The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples:

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows in this case is 3, which is the largest among all possible ways.

 */
import java.util.*;

public class AggressiveCows {
    public static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int count = 1; // place first cow
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= minDist) {
                count++;
                lastPos = stalls[i];
                if (count == cows) return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid;
                low = mid + 1; // try for bigger distance
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;
        System.out.println("Largest minimum distance: " + aggressiveCows(stalls, cows));
    }
}
