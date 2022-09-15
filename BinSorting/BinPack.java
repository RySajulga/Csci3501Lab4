package BinSorting;
//Lab 4
//Conner and Ryan
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class BinPack{

    public void binOrganizer(int binSize, int numItems, String items){
        // Using the scanner class to grab all of the intergers
        Scanner numbers = new Scanner(items);
        int[] numArray = new int[numItems];
        for (int i = 0; i < numItems; i++) {
            numArray[i] = numbers.nextInt();
        }
        //System.out.println(Arrays.toString(numArray));

        Bin[] bins = new Bin[3];
        bins[0] = new Bin(numArray.length, binSize);
        bins[1] = new Bin(numArray.length, binSize);
        bins[2] = new Bin(numArray.length, binSize);

        for (int number : numArray) {
            int index = 0;

            for (Bin bin : bins) {
                if(bin.total + number > binSize){
                    index++;
                    break;
                }
            }

            bins[index].insert(number);
        }

        int stringIndex = 1;
        for (Bin bin : bins) {
            System.out.println("bin " + stringIndex + ": " + Arrays.toString(bin.items));
            stringIndex++;
        }

    }

    public static void main(String[] args) {
        String seriesOfNumbers = "1 2 3 4 5 6 7 5";

        BinPack salmon = new BinPack();
        salmon.binOrganizer(20, 8, seriesOfNumbers);
    }
}