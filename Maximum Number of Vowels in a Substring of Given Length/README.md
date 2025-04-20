# 1456. Maximum Number of Vowels in a Substring of Given Length - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - Maximum Number of Vowels in a Substring of Given Length](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/)  

## Description
Given a string `s` and an integer `k`, return *the maximum number of vowel letters in any substring of `s` with length `k`*. **Vowel letters** in English are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

## Example 1:
Input: `s = "abciiidef", k = 3`  
Output: `3`  
Explanation: The substring `"iii"` contains `3` vowel letters.

## Example 2:
Input: `s = "aeiou", k = 2`  
Output: `2`  
Explanation: Any substring of length `2` contains `2` vowels.

## Example 3:
Input: `s = "leetcode", k = 3`  
Output: `2`  
Explanation: `"lee"`, `"eet"` and `"ode"` contain `2` vowels each.

## Constraints:
* `1 <= s.length <= 10`<sup>`5`</sup>
* `s` consists of lowercase English letters.
* `1 <= k <= s.length`

## Solution
Clearly, this is a sliding window problem. Here is the solution outline.
* Count the number of vowels in the first `k` characters of input string `s`. Let's call this `count`.
* Initialize `maxCount = count`.
* Iterate thru' the input string `s`, to count vowels for each subsequent sliding window:
    * To get the current `count`, reduce `count` if the first character of previous sliding window is a vowel and increase `count` if the last character of current sliding window is a vowel.
    * First character of previous sliding window is `s[i]`.
    * Last character of current sliding window is `s[i+k]`. 
    * Update `maxCount` if `maxCount > count`.
* Return `maxCount`.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the array, n.

## Space Complexity:
* **O(1):** Constant space is used in the form of variables to calculate `count` and `maxCount`.

## Dry Run
Input: `s = "abciiidef", k = 3`  
Variables: count = 0, maxSumK

Calculate `count` for the first sliding window.

| i | s[i]  | isVowel | count |
| - | ----- | ------- | ----- |
| 0 | 'a'   | false   | 0     |
| 1 | 'b'   | false   | 0     |
| 2 | 'c'   | false   | 0     |

* Count of Vowels in first sliding window `(s[0 to 2]) = count = 0`.
* `maxCount = count = 0`.
* `isVowel[s[i]], count--`.
* `isVowel[s[i+k]], count++`.

| Sliding Window | i | s[i] | i+k | s[i+k] | isVowel(s[i]) | count   | isVowel(s[i+k]) | count   | maxCount      |
| -------------- | - | ---- | --- | ------ | ------------- | ------- | --------------- | ------- | ------------- |
| `s[1 to 3]`    | 0 | 'a'  | 3   | 'i'    | false         | 0       | true            | 0++ = 1 | max(0, 1) = 1 |
| `s[2 to 4]`    | 1 | 'b'  | 4   | 'i'    | false         | 1       | true            | 1++ = 2 | max(1, 2) = 2 |
| `s[3 to 5]`    | 2 | 'c'  | 5   | 'i'    | false         | 2       | true            | 2++ = 3 | max(2, 3) = 3 |
| `s[4 to 6]`    | 3 | 'i'  | 6   | 'd'    | true          | 3-- = 2 | false           | 2       | max(3, 2) = 3 |
| `s[5 to 7]`    | 4 | 'i'  | 7   | 'e'    | true          | 2-- = 1 | false           | 1       | max(3, 1) = 3 |
| `s[6 to 8]`    | 5 | 'i'  | 8   | 'f'    | true          | 1-- = 0 | false           | 0       | max(3, 0) = 3 |

Return `maxCount = 3`

## Source Code
[C++ Implementation](./maxVowels.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*