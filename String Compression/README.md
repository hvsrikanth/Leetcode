# 443. String Compression - Leetcode Problem  

*Difficulty - Medium*  

[Leetcode Link - String Compression](https://leetcode.com/problems/string-compression/)  

## Description
Given an array of characters `chars`, compress it using the following algorithm:  
Begin with an empty string `s`. For each group of **consecutive repeating characters** in `chars`:
* If the group's length is `1`, append the character to `s`.
* Otherwise, append the character followed by the group's length.

The compressed string `s` **should not be returned separately**, but instead, be stored in the **input character array** `chars`. Note that group lengths that are `10` or longer will be split into multiple characters in `chars`. After you are done **modifying the input array**, return *the new length of the array*.  
You must write an algorithm that uses only constant extra space.

## Example 1:
Input: chars = ["a","a","b","b","c","c","c"]  
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]  
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

## Example 2:
Input: chars = ["a"]  
Output: Return 1, and the first character of the input array should be: ["a"]  
Explanation: The only group is "a", which remains uncompressed since it's a single character.

## Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]  
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].  
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

## Constraints:
1 <= chars.length <= 2000  
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

## Solution
*Frankly it took me a while to understand the problem. My initial submission failed because, the test cases expect the input character array to be modified. I was only returning the lenght of the compressed string. I used the discussion forum on Leetcode to confirm that the input character needs to be modified and is part of the test case. To confirm my understanding, my local runs was using extra space. Here is the final solution*.  

We will use two pointers to iterate thru' the input string - one to read and one to write.
* Two variables `i` and `result` both initialized to 0. One to iterate the array and the other to store the lenght of the compressed string.
* Iteratate while is less than size of input array:
    * Initialize `count` to 1. This counts the repeated characters in the array. Increment the `count`, while chars[`i+count`] = chars[`i`]
    * Modify input array and set chars[`result`] = chars[`i`] and increment `result`.
    * If `count` > 1, convert `count` to character array and add the elements to chars.
    * Move the index `i` by `count` and move to the next set of repeated characters.

## Time Complexity:
* **O(n):** Time complexity is proportional to the size of the input array. Hence, linear complexity.
## Space Complexity:
* **O(1):** Constant space is used in terms of few variables. Input array is modified in memory and returned.

## Dry Run

Input: chars = ["a","a","b","b","c","c","c"]  
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]  
Variables: size = 7 (length of chars array), i = 0, result = 0

| i |count     |char[i]|chars[i+count]  | count | chars[result]  | result++ | count > 1      | Updated chars array           | i += count |
| - |--------- |-------|----------------| ----- | -------------- | -------- | -------------- | ----------------------------- | ---------- |
| 0 | 1        |"a"    |chars[0+1] = "a"| 2     | -              | -        | -              | -                             | -          |
| 0 | 2        |"a"    |chars[0+2] = "b"| 2     | chars[0] = "a" | 1        | chars[1] = "2" | ["a","2","b","b","c","c","c"] | i = 0+2 = 2|
|   |          |       |                |       |                |          | result++ = 2   |                               |            |
| 2 | 1 (reset)|"b"    |chars[2+1] = "b"| 2     | -              | _        | -              | -                             | -          |
| 2 | 2        |"b"    |chars[2+1] = "c"| 2     | chars[2] = "b" | 3        | chars[3] = "2" | ["a","2","b","2","c","c","c"] | i = 2+2 = 4|
|   |          |       |                |       |                |          | result++ = 4   |                               |            |
| 4 | 1 (reset)|"c"    |chars[4+1] = "c"| 2     | -              | -        | -              | -                             | -          |
| 4 | 2        |"c"    |chars[4+2] = "c"| 3     | chars[4] = "c" | 5        | chars[5]= "3"  | ["a","2","b","2","c","3","c"] | i = 4+3 = 7|
|   |          |       |                |       |                |          | result++ = 6   |                               |            |
* Output:
    * result = 6  
    * Updated chars = ["a","2","b","2","c","3","c"]

## Source Code
[C++ Implementation](./compress.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*