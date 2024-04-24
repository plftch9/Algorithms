import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers
//this program will use selection sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n^2)
public class SelectionSort {

    public static void main(String[] args) {

        if (args.length > 0) {

            try {

                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to bubble sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        selectionLarge(fileArray);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        selectionSmall(fileArray);
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

    public static void selectionLarge(int[] arr) {

        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }

            Utils.valueSwap(arr, largest, lastUnsortedIndex);
        }
    }

    public static void selectionSmall(int[] arr) {

        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int smallest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] < arr[smallest]) {
                    smallest = i;
                }
            }

            Utils.valueSwap(arr, smallest, lastUnsortedIndex);
        }
    }
}
