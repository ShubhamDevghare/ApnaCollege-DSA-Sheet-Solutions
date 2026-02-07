package STACK_and_QUEUE;
/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.
 */
/*
Rule (very important)
======================
👉 Every minute, a fresh orange that is up, down, left, or right of a rotten one becomes rotten.
   No diagonals ❌
 */
import java.util.*;
public class RottenOranges {

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            Queue<int[]> queue = new LinkedList<>();
            int fresh = 0;

            // Step 1: collect rotten oranges and count fresh ones
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }

            // If no fresh oranges
            if (fresh == 0) return 0;

            int minutes = 0;
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            // Step 2: BFS
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean rottedThisMinute = false;

                for (int i = 0; i < size; i++) {
                    int[] curr = queue.poll();
                    int x = curr[0], y = curr[1];

                    for (int[] d : directions) {
                        int nx = x + d[0];
                        int ny = y + d[1];

                        if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                            grid[nx][ny] = 2;
                            fresh--;
                            queue.offer(new int[]{nx, ny});
                            rottedThisMinute = true;
                        }
                    }
                }

                if (rottedThisMinute) minutes++;
            }

            return fresh == 0 ? minutes : -1;
        }
    }
