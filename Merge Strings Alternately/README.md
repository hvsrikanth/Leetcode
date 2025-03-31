# 1768. Merge Strings Alternately - Leetcode Problem
*Difficulty - Easy*  
[Leetcode Link - Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/description/)
## Description
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.  
Return the merged string.
## Example 1:
Input: word1 = "abc", word2 = "pqr"  
Output: "apbqcr"  
Explanation: The merged string will be merged as so:  
word1:  a   b   c  
word2:    p   q   r  
merged: apbqcr  

## Example 2:
Input: word1 = "ab", word2 = "pqrs"  
Output: "apbqrs"  
Explanation: Notice that as word2 is longer, "rs" is appended to the end.  
word1:  a   b  
word2:    p   q   r   s  
merged: apbqrs  

## Example 3:
Input: word1 = "abcd", word2 = "pq"  
Output: "apbqcd"  
Explanation: Notice that as word1 is longer, "cd" is appended to the end.  
word1:  a   b   c   d  
word2:    p   q  
merged: apbqcd

## Constraints:
1 <= word1.length, word2.length <= 100  
word1 and word2 consist of lowercase English letters.

## Solution:
Input strings word1 and word2 could be of two different lengths. Solution needs to iterate over both the input strings and create a merged string.
* Get the lengths of the input strings word1 and word2 into len1 and len2.
* Create an empty output string result
* Run a for loop from i = 0 to maximum of len1 and len2 to iterate thru' the input strings word1 and word2.
* Append word1[i] to result if i < len1.
* Append word2[i] to result if i < len2.
* Return result.

## Time Complexity:
**O(n)** O(max(len1, len2)) - Iterate over the longest length of the input strings word1 and word2.

## Space Complexity:
**O(1)** Use constant space to iterate over the inputs strings word1 and word2. Output string result is ignored for space complexity as it is expected output.

## Dry Run:
word1 = "ab"  
word2 = "pqrs"  
len1 = 2, len2 = 4  
result = ""  

|   i   |   i < len1    |   result    |   i < len2   |   result    |
| ----- |  -----------  | ----------- | ------------ | ----------- |
|  0    | 0 < 2 (True)  | "a"         | 0 < 4 (True) | "ap"        |
|  1    | 1 < 2 (True)  | "apb"       | 1 < 4 (True) | "apbq"      |
|  2    | 2 < 2 (False) |             | 2 < 4 (True) | "apbqr"     |
|  3    | 3 < 2 (False) |             | 3 < 4 (True) | "apbqrs"    |

## Source Code:
[C++ Implementation](./mergeStringsAlternately.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go will be added shortly.*