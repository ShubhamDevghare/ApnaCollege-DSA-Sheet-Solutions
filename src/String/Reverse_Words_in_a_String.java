package String;
/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
-----------
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
----------
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
----------
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
/*
Strategy
---------
- Trim the string to remove leading/trailing spaces
- Split on one-or-more spaces using regex: \\s+
- Reverse the array of words
- Join with a single space
 */

public class Reverse_Words_in_a_String {
        public String reverseWords(String s) {
            // Step 1: trim leading and trailing spaces
            s = s.trim();

            // Step 2: split by one or more spaces
            String[] words = s.split("\\s+");

            // Step 3: reverse words in-place
            int left = 0, right = words.length - 1;
            while (left < right) {
                String temp = words[left];
                words[left] = words[right];
                words[right] = temp;
                left++;
                right--;
            }
            //The code snippet String.join(" ", words); is used to concatenate the elements of an array or collection of strings (represented by words)
            // into a single string, with each element separated by a single space (" ").

            // Step 4: join with single spaces
            String ansString =  String.join(" ", words);
            return ansString;
        }
    }
