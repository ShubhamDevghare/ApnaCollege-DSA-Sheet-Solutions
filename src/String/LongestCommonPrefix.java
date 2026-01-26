package String;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
---------
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
---------
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
import java.util.Arrays;
public class LongestCommonPrefix {
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            Arrays.sort(strs);

            String str1 = strs[0];
            String str2 = strs[strs.length - 1];

            int index = 0;
            while (index < str1.length() && index < str2.length()) {
                if (str1.charAt(index) == str2.charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }

            return index == 0 ? "" : str1.substring(0, index);
        }
}
