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

        int[][] bins = new int[3][numArray.length];
        int index = 0;
        int binIndex = 0;
        int currBinTotal = 0;
        for (int number : numArray) {

            if(currBinTotal + number > binSize){
                index++;
                currBinTotal = 0;
                binIndex = 0;
            }

            bins[index][binIndex] = number;
            currBinTotal = number + currBinTotal;
            binIndex++;
        }

        index = 1;
        for (int[] bin : bins) {
            System.out.println("bin " + index + ": " + Arrays.toString(bin));
            index++;
        }

    }

    public static void main(String[] args) {
        String seriesOfNumbers = "1 2 3 4 5 6 7";

        BinPack salmon = new BinPack();
        salmon.binOrganizer(20, 7, seriesOfNumbers);
    }
}