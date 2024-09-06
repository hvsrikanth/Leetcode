# 5. Longest Palindromic Substring - Leetcode Problem  

*Difficulty - Medium*  
[Leetcode Link - Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)

## Description
Given a string s, return the longest palindromic substring in s.  

Example 1:  
Input: s = "babad"  
Output: "bab"  
Explanation: "aba" is also a valid answer.  

Example 2:  
Input: s = "zxcabebad"  
Output: "abeba"  
Explanation: "beb" and "abeba" are palindromic substrings. "abeba" is the longest.

## Constraints:
* 1 <= s.length <= 1000
* s consist of only digits and English letters.

## Solution
* Find the palindrome within the input string s using an expand around the center approach. Idea is to expand from the center (given by i and j) to find the largest palindrome centered at i (for odd-length) or between i and j (for even-length). It expands as long as the characters at the left and right indices are the same and ensures we stay within the bounds of the string. After expanding, we get the substring that corresponds to the palindrome.
* Solution iterates through each character in the string as a potential center of a palindrome. For each character, it considers two cases:
    * Odd-length palindrome: Centered at a single character.
    * Even-length palindrome: Centered between two consecutive characters.

## Key Points:
* **Expand-Around-Center:** The algorithm treats each character (and the gap between consecutive characters) as potential centers of a palindrome. For each center, it expands outward to check for the largest palindrome.
* **Odd and Even Lengths:** For each character, it checks for both odd-length and even-length palindromes.
* **Palindrome Expansion:** It uses two pointers, left and right, which expand outward as long as the characters at those positions are the same.
* **Tracking Longest Palindrome:** The algorithm keeps track of the longest palindrome found by comparing the length of each expanded palindrome to the longest one found for each iteration.

## Time Complexity
* **O(n<sup>2</sup>):** Solution expands around each center in O(n) time, for n centers. Hence **O(n<sup>2</sup>)**.
* *I shall work to solve this in O(n) time complexity.*

## Space Complexity
* **O(n):** Solution stores the resulting longest palindrome substring which can be the string itself.

## Dry Run
Input string s: "zxcabebad"
Length of string s: 9
Initial value of longest: "z"

|    i    |    j    | Odd Palindrome | Even Palindrome |    Longest    |
| ------- | ------- | -------------- | --------------- | ------------- |
|    0    |    0    |      "z"       |       ""        |     "z"       |
|    0    |    1    |                |       ""        |     "z"       |
|    1    |    1    |      "x"       |       ""        |     "z"       |
|    1    |    2    |                |       ""        |     "z"       |
|    2    |    2    |      "c"       |       ""        |     "z"       |
|    2    |    3    |                |       ""        |     "z"       |
|    3    |    3    |      "a"       |       ""        |     "z"       |
|    3    |    4    |                |       ""        |     "z"       |
|    4    |    4    |      "b"       |       ""        |     "z"       |
|    4    |    5    |                |       ""        |     "z"       |
|    5    |    5    |    "abeba"     |       ""        |   "abeba"     |
|    5    |    6    |                |       ""        |   "abeba"     |
|    6    |    6    |      "b"       |       ""        |   "abeba"     |
|    6    |    7    |                |       ""        |   "abeba"     |
|    7    |    7    |      "a"       |       ""        |   "abeba"     |
|    7    |    8    |                |       ""        |   "abeba"     |

Longest palindromic substring is: "abeba"

[C++ Implementation](./longestPalindromicSubstring.cpp)  
[Java Implementation](./Solution.java)

*Javascript and GO implementations to be added shortly.*