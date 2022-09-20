package BinSorting;
//Lab 4
//Conner and Ryan
import java.util.Arrays;
import java.util.Scanner;



public class BinPack{

    public void binOrganizer(int binSize, int numItems, int[] numArray){
        
        // This creates the three Bin class instances and puts them into an array
        Bin[] bins = new Bin[3];
        bins[0] = new Bin(numArray.length, binSize);
        bins[1] = new Bin(numArray.length, binSize);
        bins[2] = new Bin(numArray.length, binSize);

        // This starts the overflow counter
        int overflow = 0;

        // For each number in the numArray, we want to check if that number will fit 
        // In a bin. The first bin we find where the number fits, we put that number in the
        // bin and then start with a different number. If a number doesn't fit into a bin,
        // we add it to the "overflow" count
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

        // This is just so we can see the output of the bins.
        int stringIndex = 1;
        for (Bin bin : bins) {
            System.out.println("bin " + stringIndex + ": " + Arrays.toString(bin.items));
            stringIndex++;
        }
        // This is so we can see how much overflow we got.
        System.out.println("Overflow: " + overflow);
        // * It might be more useful to make this an array.

        // Note: Moving forward we should make this output percentages used for each bin.

    }

    public static void main(String[] args) {
        // Here I use the same scanner to scan three different inputs to find
        // The size of the bins, the number of items to sort, and the items themselves.
        System.out.println("Please enter the size of the three bins: ");
        Scanner scanner = new Scanner(System.in);
        int binSize = scanner.nextInt();

        System.out.println("Now enter the amount of integers that will be inputed: ");
        scanner = new Scanner(System.in);
        int numItems = scanner.nextInt();

        System.out.println("Finally, enter the desired integers: ");
        scanner = new Scanner(System.in);
        int[] numArray = new int[numItems];
        for (int i = 0; i < numItems; i++) {
            numArray[i] = scanner.nextInt();
        }
        scanner.close();

        // This creates an instnace of the BinPack class and then inputs the 
        // given system inputs into our function
        BinPack BinPackInstance = new BinPack();
        BinPackInstance.binOrganizer(binSize, numItems, numArray);
    }
}