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
        numbers.close();

        Bin[] bins = new Bin[3];
        bins[0] = new Bin(numArray.length, binSize);
        bins[1] = new Bin(numArray.length, binSize);
        bins[2] = new Bin(numArray.length, binSize);

        int overflow = 0;

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

        int stringIndex = 1;
        for (Bin bin : bins) {
            System.out.println("bin " + stringIndex + ": " + Arrays.toString(bin.items));
            stringIndex++;
        }
        System.out.println("Overflow: " + overflow);

    }

    public static void main(String[] args) {
        String seriesOfNumbers = "20 20 20";
        BinPack salmon = new BinPack();
        salmon.binOrganizer(20, 3, seriesOfNumbers);

        // Example for a system input to output
        //Scanner potato = new Scanner(System.in);
        //System.out.println(potato.nextInt());
    }
}