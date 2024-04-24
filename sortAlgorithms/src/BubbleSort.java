import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers
//this program will use bubble sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n^2)
public class BubbleSort {
    public static void main(String[] args) {
        if (args.length > 0) {

            try {
                // File fileArg = new File(args[0]);
                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to bubble sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        bubbleLarge(fileArray);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        bubbleSmall(fileArray);
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

    public static void bubbleLarge(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    Utils.valueSwap(arr, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSmall(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arr[i] < arr[i + 1]) {
                    Utils.valueSwap(arr, i, i + 1);
                }
            }
        }
    }

}
