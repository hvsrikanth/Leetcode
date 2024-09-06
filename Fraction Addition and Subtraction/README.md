# 592. Fraction Addition and Subtraction - Leetcode Problem
*Difficulty - Medium*  
[Leetcode Link - Fraction Addition and Subtraction](https://leetcode.com/problems/fraction-addition-and-subtraction/description/)  

## Description
Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format. The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.  

### Example 1:  
Input: expression = "-1/2+1/2"  
Output: "0/1"

### Example 2:  
Input: expression = "-1/2+1/2+1/3"  
Output: "1/3"

## Constraints
* The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
* Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
* The input only contains valid **irreducible fractions**, where the **numerator** and **denominator** of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
* The number of given fractions will be in the range [1, 10].
* The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

## Solution
Solution outline comprises of 3 major steps:
1. **Fraction Parsing:** Extraction the fraction from the string and handle the signs. Numerator and denominator are parsed separately from the string.
2. **Addition:** Fractions are added using a common denominator approach i.e., num = num * den2 + num2 * den. den = den * den2.
3. **Simplification:** After each addition, simplify the fraction using the GCD of numerator and denominator.

## Time Complexity
* **O(N * LogM):** where N is the length of the string and M is the maximum value of Numerator or Denominator. GCD operation contributes to the time complexity.

## Space Complexity
* **O(1):** since the solution uses only a few variables to store the intermediate results.

## Dry Run

Input: expression = "-1/12-5/12+7/12-11/12"  
Output: -5/6  
Initial values: numerator = 0, denominator = 1

| expression              | sign | temp Numerator | temp Denominator | numerator                | denominoator  | Simplified | 
| ----------------------- | ---- | -------------- | ---------------- | -------------------      | ------------  | ---------- |
| "-1/12-5/12+7/12-11/12" | -1   | -1             | 12               | 0 * 12 + 1 * -1 = -1     | 1 * 12 = 12   | -1, 12     |
| "-5/12+7/12-11/12"      | -1   | -5             | 12               | -1 * 12 + -5 * 12 = -72  | 12 * 12 = 144 | -1, 2      |
| "+7/12-11/12"           | +1   | 7              | 12               | -1 * 12 + 7 * 2 = 2      | 2 * 12 = 24   | 1, 12      |
| "-11/12"                | -1   | -11            | 12               | -11 * 12 + 1 * 12 = -120 | 12 * 12 = 144 | -5, 6      |

**Output:** -120/144 = -5/6

## Source Code
[C++ Implementation](./fractionAddSubtract.cpp)  
[Java Implementation](./Solution.java)

*Javascript and Go will be added shortly.*