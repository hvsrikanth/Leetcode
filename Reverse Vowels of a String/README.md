# 345. Reverse Vowels of a String - Leetcode Problem

*Difficulty - Easy*  

[Leetcode Link - Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)

## Description
Given a string s, reverse only all the vowels in the string and return it. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

## Example 1:
Input: s = "IceCreAm"  
Output: "AceCreIm"  
Explanation: The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".  

## Example 2:
Input: s = "leetcode"  
Output: "leotcede"  

## Constraints:
1 <= s.length <= 3 * 10<sup>5</sup>  
s consist of printable ASCII characters.

## Solution:
As the problem involves looking for vowels from left and right sides of the input string, we will use two pointers based approach to solve the problem. Below is the outline of the solution.
* Initialize two pointers left = 0 and right = length of s - 1.
* Loop thru' the string while left < right.
* If both left and right are pointing at vowels, swap the vowels and increment left and decrement right.
* If left is not pointing at vowel, increment left to move it towards right.
* If right is not pointing at vowel, decrement right to move it towars left.

## Time Complexity:
**O(n):** Solution moves thru' the length of the string in search of vowels and hence linear complexity.

## Space Complexity:
**O(n):** Solution uses linear space in worst case if all characters are vowels. In Java, one has to use a character array and hence linear complexity.

## Dry Run:
Input: s = "IceCreAm"  
Variables: left = 0, right = 7  

| Iteration | left | s[left] | right | s[right] | Updated s |
| --------- | ---- | ------- | ----- | -------- | --------- |
| 1         | 0    | I       | 7     | m        | IceCreAm  |
| 2         | 0    | I       | 6     | A        | AceCreIm  |
| 3         | 1    | c       | 5     | e        | AceCreIm  |
| 4         | 2    | e       | 5     | e        | AceCreIm  |
| 5         | 3    | C       | 4     | r        | AceCreIm  |
| 6         | 4    | r       | 3     | C        | AceCreIm  |

Output s = "AceCreIm"

## Source Code:
[C++ Implementation](./reverseVowels.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go implementations will be added shortly.*