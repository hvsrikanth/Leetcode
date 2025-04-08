# 392. Is Subsequence - Leetcode Problem  

*Difficulty - Easy*  

[Leetcode Link - Is Subsequence](https://leetcode.com/problems/is-subsequence/description/)  

## Description
Given two strings `s` and `t`, return `true` if `s` is a **subsequence** of `t`, or `false` otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).

## Example 1:
Input: `s` = `"abc"`, `t` = `"ahbgdc"`  
Output: `true`

## Example 2:
Input: `s` = `"axc"`, `t` = `"ahbgdc"`  
Output: `false`

## Constraints:
0 <= s.length <= 100  
0 <= t.length <= 10<sup>4</sup>  
`s` and `t` consist only of lowercase English letters.

## Solution
We have two strings, `t` and `s`. We have to check whether `s` is a subsequence of `t`. Meaning, we need to check if every character in `s`, appears in `t` and in the same sequence. We will two pointer approach in our solution.
* Two pointers `i` and `j` for each string `t` and `s`.
    * `i` is used to iterate the longer string `t`.
    * `j` is used to iterate the smaller string `s`.
* While iterating the longer string `t`, check if every character in `s` matches with that of `t`.
    * If there is a match, increment `j` to move to next character in `s`.
    * If there is no match, increment `i` to move to next character in `t`.
* **Subsequence check:**
    * If `j` is equal to the length of `s`, subsequence exists and return `true`.
    * Else return `false` at the end of all iterations.

## Time Complexity:
* **O(n):** Time complexity is proportional to the length of the input string t. Hence, of linear time complexity.
## Space Complexity:
* **O(1):** Constant space is used in terms of two pointer variables.

## Dry Run

Input: `s = "agd"`, `t = "ahbgdc"`  
Variables: `i = 0`, `j = 0`  
Length of s = 3, Length of t = 6  

| i | j | s[j] = t[i] | i++ | j++ | Subsequence Check |
| - | - | ----------- | --- | --- | ----------------- |
| 0 | 0 | a == a      | 1   | 1   | 1 != 3            |
| 1 | 1 | g != h      | 2   | -   | 1 != 3            |
| 2 | 1 | g != b      | 3   | -   | 1 != 3            |
| 3 | 1 | g == g      | 4   | 2   | 2 != 3            |
| 4 | 2 | d == d      | 5   | 3   | 3 == 3            |

Return `true`.  
(`j = 3`) == (`length of s = 3`) and hence `s` is a subsequence of `t`.

## Source Code
[C++ Implementation](./isSubsequence.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*