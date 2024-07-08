import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers
//this program will use insertion sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n^2)

public class InsertionSort {

    public static void main(String[] args) {

        if (args.length > 0) {

            try {

                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to insertion sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");
                System.out.println("3. Recurrsive Sort");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        insertionLarge(fileArray);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        insertionSmall(fileArray);
                        Utils.displayResults(fileArray);
                        break;

                    case 3:
                        insertionRecursive(fileArray, fileArray.length);
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

    public static void insertionLarge(int[] arr) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }

            arr[i] = newElement;
        }
    }

    public static void insertionSmall(int[] arr) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] < newElement; i--) {
                arr[i] = arr[i - 1];
            }

            arr[i] = newElement;
        }
    }

    public static void insertionRecursive(int[] arr, int numItems) {
        if (numItems < 2) {
            return;
        }

        insertionRecursive(arr, numItems - 1);

        int newElement = arr[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && arr[i - 1] < newElement; i--) {
            arr[i] = arr[i - 1];
        }

        arr[i] = newElement;
    }

    // TODO: Add recursive implementation
}
