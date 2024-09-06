# 476. Number Complement - Leetcode Problem

*Difficult - Easy*  
[Leetcode Link - Number Complement](https://leetcode.com/problems/number-complement/description/)  

## Description
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.  

Example 1:  
Input: num = 5  
Output: 2  
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.  

Example 2:  
Input: num = 8  
Output: 7  
Explanation: The binary representation of 8 is 1000 (no leading zero bits), and its complement is 0111. So you need to output 7.  
 

## Constraints:
1 <= num < 2<sup>31</sup>  

## Solution
Bruteforce solution is to convert the input num into a string with binary representation using long division methond. Then flipping the 1's to 0's and 0's to 1's in the string and compute the complement. However, this is of logarithmic complexity.  
A better solution is using the bitwise operators to get the complement. Idea is to flip all the bits of the number within a relevant range of bits that represent the number. E.g.: for input num = 5, relevant bits range is 3 as the binary representation of 5 is 101.
1. Create an initial mask with all bits set to 1 (which is ~0).
2. Modify the mask to match the relevant range of bits of the input num.
    * Left shift the mask until the range of bits match with input num.
3. Negate the mask to get bits set to right range of bits and then XOR with input num.
    * complement = ~mask ^ num

## Time Complexity
* **O(1):** The number of bits in an integer is constant (e.g., 32 bits for a 32-bit integer), so the number of operations performed is fixed and does not grow with the size of the input number. Bitwise NOT (~), AND (&), XOR (^), and left-shifting (<<) are all constant-time operations.

## Space Complexity
* **O(1):** Only additional space taken is that of the mask which is constant regardless of the input.

## Dry Run
*Assuming 32 bit representation*  
Input num = 5  
Initial mask = ~0
Binary of 5 =    00000000 00000000 00000000 00000101  
Binary of mask = 11111111 11111111 11111111 11111111  
Iterate until the relevant bits of input num is covered i.e., while (mask & num != 0)  
|  Iteration  |                 Mask                |          Left Shifted Mask          |
| ----------- | ----------------------------------- | ----------------------------------- |
|      1      | 11111111 11111111 11111111 11111111 | 11111111 11111111 11111111 11111110 |
|      2      | 11111111 11111111 11111111 11111110 | 11111111 11111111 11111111 11111100 |
|      3      | 11111111 11111111 11111111 11111100 | 11111111 11111111 11111111 11111000 |

~Mask = ~(11111111 11111111 11111111 11111000) = 00000000 00000000 00000000 00000111  
*Ignoring the leading 0's*  
~Mask = 111   
Complement = ~Mask ^ num = 111 ^ 101 = 010 = 2  

[C++ Implementation](./numberComplement.cpp)  
[Java Implementation](./Solution.java)  

*Javascript and Go implementations will be added shortly.*