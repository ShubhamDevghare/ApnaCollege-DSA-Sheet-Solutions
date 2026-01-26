package String;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
----------
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
---------
Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}
