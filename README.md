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


## Efficiency Analysis
Most of the code has a constant cost, O(1). The only spot that doesn't have constant cost is the nested for loop.

```Java
        for (int number : numArray) {
            for (int i = 0; i < bins.length; i++) {
                if(bins[i].total + number <= binSize){
                    bins[i].insert(number);
                    break;
                } else if(i == bins.length - 1){
                    overflow = overflow + number;
                }
            }
        }
```

Here we go through each number in the given "Array," which was set up in preprocessing (Took the input and used the scanner to put it into an array of numbers), then check each bin one-by-one and put the number into the first one it can fit in. In the worst case scenario, every number would be too big for the bins (in the example every number would be above 20) and the function would have to check all three bins for every number. This would mean the function, at the worst case, would run at bigO(3n). So the total cost of the function would be 3n + C, which is polynomial. However in Big O notation we can ignore the extra constants and say that our worst case scenario is bigO(n). If we need to include the scanner in this analysis (the preprocessing part), we could still say our function is in Big0(n) since the cost would instead be 4n + C.