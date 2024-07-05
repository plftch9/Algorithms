import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers
//this program will use counting sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n)

public class CountingSort {

    public static void main(String[] args) {

        if (args.length > 0) {

            try {

                int[] fileArray = Utils.loadArray(new File(args[0]));
                int[] minMax = Utils.getMinMax(fileArray);

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to insertion sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        countingLarge(fileArray, minMax[1], minMax[0]);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        countingSmall(fileArray, minMax[1], minMax[0]);
                        Utils.displayResults(fileArray);
                        break;

                    default:
                        System.out.println("That is not one of the options");

                }
            } catch (FileNotFoundException noFile) {
                System.out.println("Provided argument cannot be found");
                System.exit(0);
            }
        } else {
            System.out.println("No argument provided. Exiting program");
            System.exit(0);
        }

    }

    public static void countingLarge(int[] arr, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                arr[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    public static void countingSmall(int[] arr, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        int j = 0;
        for (int i = max; i >= min; i--) {
            while (countArray[i - min] > 0) {
                arr[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
