package String;
/*
Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

Example 1:
----------
Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
 */
public class RemoveAllOccurrencesOfString {
        public String removeOccurrences(String s, String part) {
            StringBuilder sb = new StringBuilder();
            int m = part.length();

            for (char c : s.toCharArray()) {
                sb.append(c);

                // Check if the end of sb matches 'part'
                if (sb.length() >= m) {
                    boolean match = true;
                    for (int i = 0; i < m; i++) {
                        if (sb.charAt(sb.length() - m + i) != part.charAt(i)) {
                            match = false;
                            break;
                        }
                    }

                    // If matched, remove it
                    if (match) {
                        sb.delete(sb.length() - m, sb.length());
                    }
                }
            }

            return sb.toString();
        }
    }
