# 151. Reverse Words in a Srring - Leetcode Problem

*Difficulty - Medium*  

[Leetcode Link - Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)  

## Description:
Given an input string s, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.  
Return a string of the words in reverse order concatenated by a single space.  

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

## Example 1:
Input: s = "the sky is blue"  
Output: "blue is sky the"

## Example 2:
Input: s = "  hello world  "  
Output: "world hello"  
Explanation: Your reversed string should not contain leading or trailing spaces.

## Example 3:
Input: s = "a good   example"  
Output: "example good a"  
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

## Constraints:
1 <= s.length <= 10<sup>4</sup>  
s contains English letters (upper-case and lower-case), digits, and spaces ' '.  
There is at least one word in s.

## Solution:
I intended to solve this problem without using the in-built methods to split the input string. We follow the two pointer approach to reverse the words in the input string while handling multiple spaces (leading, trailing and in-between).
* Initialize Pointers:  
    end points to the last character of the string.  
    start identifies the beginning of each word.  
    result holds the final reversed output.  
* Iterate from the End:  
    Skip trailing spaces using a loop.  
    If the end of the string is reached, break the loop.  
* Identify Each Word:  
    Move start towards left to find the start of the current word.  
    Use substr(start + 1, end - start) to extract the word.  
* Build the Result:  
    Add a space before the word if the result already has content.  
    Append the word to result.  
* Move to the Next Word:  
    Update end = start - 1 to process the next word.  
* Return the Result:  
    Once the loop finishes, return the final result.  
## Time Complexity:
**O(n):** Each character in the string is inspected and processed once. Hence linear complexity.

## Space Complexity:
**O(n):** Using additional space in the form of variables (StringBuilder in Java) determined by the size of the input string.

## Dry Run:
Input: "a good   example"  
Variables: n = 16, end = 15, start = 15, result = ""  
|   end   |  start  | s[start] | s[end] | current word | result         |
| ------- | ------- | ------   | ------ | ------------ | -------------- |
| 15      | 15      | e        | e      | ""           | ""             |
| 15      | 8       | ' '      | e      | example      | example        |
| 7       | 8       | ' '      | ' '    | ""           | example        |
| 5       | 5       | d        | d      | ""           | example        |
| 5       | 1       | ' '      | d      | good         | example good   |
| 0       | 0       | a        | a      | a            | example good a |

result = "example good a"  

## Source Code:
[C++ Implementation](./reverseWords.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go will be added shortly.*