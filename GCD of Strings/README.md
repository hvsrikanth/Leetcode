# 1071. Greatest Common Divisor of Srrings - Leetcode Problem
*Difficulty - Easy*  

[Leetcode Link - Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/description/)  

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).  
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

## Example 1:
Input: str1 = "ABCABC", str2 = "ABC"  
Output: "ABC"

## Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"  
Output: "AB"

## Example 3:
Input: str1 = "LEET", str2 = "CODE"  
Output: ""

## Constraints:
1 <= str1.length, str2.length <= 1000  
str1 and str2 consist of English uppercase letters.

## Solution:
I tried multiple solutions before arriving at this solution. One of the attempts involved checking of divisibility of length of one strings with that of the other and then further string operations. But, they failed in test case given in Example 2. Now the hint to solve this is in the description which says t divides s only if s = t + t + ... + t + t. This t can have further repeatable pattern which repeats in both input strings str1 and str2. That repeatable sub-pattern is the GCD!! This and Example 2 is the source for below solution.
* Check if str1 + str2 is equal to str2 + str1. If same, then we have a string GCD. Otherwise, return empty string.
* GCD i.e., the repeatable pattern t is the smallest string repeated in both str1 and str2.
* Length of the repeatable pattern t is the GCD of lengths of both the strings.
* Return substring from str1 or str2 from 0 of length of GCD pattern.

## Time Complexity:
**O(n):** O(len1 + len2) - To compare the concatenation of the input strings str1 and str2.

## Space Complexity:
**O(n):** O(len1 + len2) - Space needed to compare the concatenation of the input strings str1 and str2.

## Dry Run:
str1 = "ABABAB"  
str2 = "ABAB"  

| Step | Operation                                | Result |
| ---- | ---------------------------------------- | ------ |
| 1    | "ABABAB" + "ABAB" == "ABAB" + "ABABAB"   | True   |
| 2    | len1 = 6, len2 = 4 GCD(6, 4)             | 2      |
| 3    | Substring of "ABABAB" from 0 of length 2 | AB     |

## Source Code:
[C++ Implementation](./gcdOfStrings.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go will be added shortly.*