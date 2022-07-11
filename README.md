# JosephusPermutations
Wrote an algorithm that solves for m in (X,m)-J-Permutation (a set of numbers); where x is the number of elements in the set. While solving the problem brute force on paper, I noticed a pattern when doing the mod of what's left in the array, it always gave the "count" of the next element that needs to be in the set. With this, my algorithm works with all sets.

Example input:

7

3 6 2 7 5 1 4

Example output:

3

Explanation:

Given 7 numbers, and the numbers are the above given, what value of m skips can give you that permutation? The answer is 3 since if you skip every third, and then after removing every value that you land on continuing with the circle that remains, you will create that permutation.
