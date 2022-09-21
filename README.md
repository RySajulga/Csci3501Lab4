# Lab 4: Approximation Algorithm for Bin Packing
##### Written by Conner and Ryan

## Successful examples:

1. Example One
- [10, 9, 8, 7 ,6 ,5 ,4, 3, 2, 1]
- Bin Size: 20
- Number of Items: 10

--------------Bin 1----------------
Items: [10, 9, 1, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 0

--------------Bin 2----------------
Items: [8, 7, 5, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 0

--------------Bin 3----------------
Items: [6, 4, 3, 2, 0, 0, 0, 0, 0, 0]
Unused Space: 5

Overflow: 0

When the list happens to be in descending order, the algorithm works better.

2. Example two
- [5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
- Bin Size: 20
- Number of Items: 12

--------------Bin 1----------------
Items: [5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 0

--------------Bin 2----------------
Items: [5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 0

--------------Bin 3----------------
Items: [5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 0

Overflow: 0

And of course when the list is identical numbers, it will always get the best result
since there would not be any other way to sort them into the different bins.



## Unsuccessful example:

- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
- Bin size: 20
- Number of Items: 10

Output: 
--------------Bin 1----------------
Items: [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
Unused Space: 5

--------------Bin 2----------------
Items: [6, 7, 0, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 7

--------------Bin 3----------------
Items: [8, 9, 0, 0, 0, 0, 0, 0, 0, 0]
Unused Space: 3

Overflow: 10

The first example above showcases how this could be properly sorted with no Overflow.