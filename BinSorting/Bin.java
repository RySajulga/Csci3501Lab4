package BinSorting;

public class Bin {

    public int total = 0; // All the elements values combined
    private int maxTotal;

    private int size; // number of elements
    public int[] items;
    public int currPos = 0;

    public Bin(int size, int max){
        items = new int[size];
        maxTotal = max;

    }

    public boolean insert(int number) {
        if (total + number < maxTotal){
            items[currPos] = number;
            currPos++;
            total = total + number;
            return true;
        }
        return false;
    }
    
}
