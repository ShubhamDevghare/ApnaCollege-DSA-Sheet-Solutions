package String;
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
---------
Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
----------
Input: strs = [""]

Output: [[""]]

Example 3:
----------
Input: strs = ["a"]

Output: [["a"]]

Constraints:
-------------
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters
 */
import java.util.*;
public class GroupAnagrams {

     public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);               // sort characters
                String key = new String(chars);   // canonical form
                // 	computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)    // ? super K → "K or its parent"    //  ? extends V → "V or its child"
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(s); // If this key doesn’t exist in the map yet,
                                                                         // create a new empty list and put it there.
                                                                         //  Then add s to the list for this key.
                       /*                if (!map.containsKey(key)) {
                                             map.put(key, new ArrayList<>());
                                         }
                                         map.get(key).add(s);
                     */
            }

            return new ArrayList<>(map.values());
        }
    }

