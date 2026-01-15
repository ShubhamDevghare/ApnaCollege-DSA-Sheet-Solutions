package Array;
import java.util.HashMap;
import java.util.Map;
/*
Longest Substring Without Repeating Characters
-----------------------------------------------
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
----------
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
---------
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
---------
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

Notice : that the answer must be a substring, "pwke" is a subsequence and not a substring.
-------


 */
/*
HashMap Basic:
--------------
HashMap is a part of the Java Collections Framework used to store data as key–value pairs.
- Keys are unique
- Values can be duplicated
- Order is not guaranteed
- Allows one null key and multiple null values
- Not thread-safe
- Order Not preserved
- Performance : O(1) avg

🔹 Basic Operations
  ------------------
put(K,V) – add/update key-value
get(Object) – get value by key
remove(Object) – remove by key
containsKey(Object) – check key exists
containsValue(Object) – check value exists

🔹 Size & State
  --------------

size() – number of entries
isEmpty() – check empty
clear() – remove all entries

🔹 Bulk Operation
  ---------------
putAll(Map) – copy all entries

🔹 Views
  --------
keySet() – all keys
values() – all values
entrySet() – key-value pairs

🔹 Java 8+ Conditional Methods
  ---------------------------
getOrDefault(K,V) – return default if key missing
putIfAbsent(K,V) – insert only if absent
remove(K,V) – remove if key-value matches
replace(K,V) – replace value if key exist
replace(K,oldV,newV) – replace if old value matches

🔹 Iteration
  ---------
forEach(BiConsumer) – iterate with lambda

🔹 Utility
  --------
equals(Object) – compare maps
hashCode() – map hashcode
clone() – shallow copy

 */
/*
🧠 Core Idea (Sliding Window)
   --------------------------
You maintain a window [left … right] that always contains unique characters.
- map stores the last index where each character appeared
- left marks the start of the current valid window
- right expands the window character by character

When a duplicate character appears inside the current window,
you move left forward to exclude its previous occurrence.

Input: "pwwkew"

| right | char | left | window | maxLen |
| ----- | ---- | ---- | ------ | ------ |
| 0     | p    | 0    | `p`    | 1      |
| 1     | w    | 0    | `pw`   | 2      |
| 2     | w    | 2    | `w`    | 2      |
| 3     | k    | 2    | `wk`   | 2      |
| 4     | e    | 2    | `wke`  | 3      |
| 5     | w    | 3    | `kew`  | 3      |

 */

public class Longest_substring_without_repeating {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
