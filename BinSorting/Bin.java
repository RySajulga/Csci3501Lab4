package BinSorting;

public class Bin {

    public int total = 0; // All the elements values combined
    public int maxTotal;

    private int size; // number of elements
    public int[] items;
    public int currPos = 0;

    public Bin(int size, int max){
        items = new int[size];
        maxTotal = max;

    }

    // When inserting something, it just checks that it is possible so the 
    // Total value of the Bin doesn't exceed the maximum amount
    // This could be removed? Since we check this already before actually inserting
    public boolean insert(int number) {
        if (total + number <= maxTotal){
            items[currPos] = number;
            currPos++;
            total = total + number;
            return true;
        }
        return false;
    }
}
