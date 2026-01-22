package Array;
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.
ie.
------------------------------------------
Rule                       Explination
------------------------------------------
Adjacent only	        Up, Down, Left, Right
No diagonals	        ❌
No reuse	            Same cell only once
Start anywhere	        Any cell can be first letter

Example 1:
---------

A B C E
S F C S
A D E E

Word = "ABCCED"
Ans :
Let’s trace it step by step.

Step-by-step Path
A → B → C → C → E → D

[A] [B]  [C]  E
 S   F   [C]  S
 A  [D]  [E]  E


Movement Explanation

Start at A (0,0)
Move right to B (0,1)
Move right to C (0,2)
Move down to C (1,2)
Move down to E (2,2)
Move left to D (2,1)

✔ All letters match
✔ All moves are horizontal/vertical
✔ No cell is reused

✅ Return true
 */

/*
Key Idea (Backtracking / DFS)
-----------------------------

We try to start the word from every cell in the grid.
From a starting cell:

1.Check if the current character matches the word.
2.Mark the cell as visited so it can’t be reused.
3.Recursively explore its 4 neighbors (up, down, left, right).
4.Backtrack (unmark the cell) if the path fails.
5.If any path forms the full word → return true.

Algorithm
----------
1. Loop through every cell in board
2. If board[i][j] == word.charAt(0):
      Run DFS from that cell
3. DFS rules:
   - Stop if index == word.length() → found the word
   - Stop if out of bounds or mismatch
   - Temporarily mark the cell as visited
   - Explore neighbors
   - Restore the cell (backtrack)
 */

public class Word_search {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int index) {
            if (index == word.length()) return true;

            if (i < 0 || i >= board.length ||
                    j < 0 || j >= board[0].length ||
                    board[i][j] != word.charAt(index)) {
                return false;
            }

            char temp = board[i][j];
            board[i][j] = '#'; // mark visited

            boolean found =
                    dfs(board, word, i + 1, j, index + 1) ||
                            dfs(board, word, i - 1, j, index + 1) ||
                            dfs(board, word, i, j + 1, index + 1) ||
                            dfs(board, word, i, j - 1, index + 1);

            board[i][j] = temp; // backtrack
            return found;
        }
    }
