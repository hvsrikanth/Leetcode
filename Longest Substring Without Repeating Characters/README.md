# 3. Longest Substring Without Repeating Characters - Leetcode Problem  
*Difficulty - Medium*  
[Leetcode Link - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

## Description
Given a string s, find the length of the longest substring without repeating characters.

Example 1:  
Input: S = "abcabcbb"  
Output: 3  
Explanation: Longest substring is "abc", with the length of 3.  

Example 2:  
Input: S = "bbbbb"  
Output: 1  
Explanation: Longest substring is "b", with the length of 1.  

Example 3:  
Input: S = "pwwkew"  
Output: 3  
Explanation: Longest substring is "wke", with the length of 3.  

## Constraints:  
0 <= S.length <= 5 * 104  
S consists of English letters, digits, symbols and spaces  

## Solution
* **Two pointers i and j:** Track the substring without repeating the characters. Idea is to use two pointers (i and j) that move and expand creating a sliding window. Sliding window expands with one pointer (j) moving right as the unique characters increase and contracts with the other pointer (i) moving right as a repeat character is found.
* **Hash Map:** A hash map is used to keep track of frequency count characters in the current window
* Iterate through the string with the pointer j, which represents the right boundary of the window
* For each character c at s[j], its count is increased in the hash map
* If a character c appears more than once (i.e., hashmap[c] > 1), the window is adjusted by moving the i pointer (left boundary) to the right until the character c appears only once again. This shrinking of the window ensures that the substring within the window contains no repeating characters
* While the frequency of the character is > 1, the character l at the position s[i] is decremented in the map as the i pointer moves forward. If its count drops to 0, it is removed from the map
* After adjusting the window, the length of the current window (i.e., j - i + 1) is compared to the longest length found so far, and the maximum is stored in longest
* After iterating through the string (when j reaches the end), return the longest

## Time Complexity
* **O(n):** where n is the length of the string S

## Space Complexity
* **O(n):** where n is the length of th string S. In the worst case where all characters of the string  are unique, hash map will store all the characters and their count  

## Dry Run
Input S = "abcabcbb"
Output Length = 3

*Initial values of i and j is 0, Longest is also 0*

|   j   |   S[ j ]   |   i   |   S[ i ]   | Window |        Hash Map        |     Longest (j-i+1)     | Hash Map Action  |
| ----- | ---------- | ----- | ---------- | ------ | ---------------------- | ----------------------- | ---------------- |
|   0   |      a     |   0   |      a     | "a"    | {a : 1}                | 0 - 0 + 1 = 1, Max: 1   | a added          |
|   1   |      b     |   0   |      a     | "ab"   | {a : 1, b : 1}         | 1 - 0 + 1 = 2, Max: 2   | b added          |
|   2   |      c     |   0   |      a     | "abc"  | {a : 1, b : 1, c : 1}  | 2 - 0 + 1 = 3, Max: 3   | c added          |
|   3   |      a     |   1   |      b     | "bca"  | {a : 2, b : 1, c : 1}  | 3 - 1 + 1 = 3, Max: 3   | a count reduced  |
|   4   |      b     |   2   |      c     | "cab"  | {a : 1, b : 2, c : 1}  | 4 - 2 + 1 = 3, Max: 3   | b count reduced  |
|   5   |      c     |   3   |      a     | "abc"  | {a : 1, b : 1, c : 2}  | 5 - 3 + 1 = 3, Max: 3   | c count reduced  |
|   6   |      b     |   5   |      c     | "cb"   | {b : 1, c : 1}         | 6 - 5 + 1 = 2, Max: 3   | a is deleted     |
|   7   |      b     |   7   |      b     | "b"    | {b : 1}                | 7 - 7 + 1 = 1, Max: 3   | c is deleted     |

[C++ Implementation](./longestSubstr.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go to be added shortly*