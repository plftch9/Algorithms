import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers
//this program will use merge sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n log n)

public class MergeSort {

    public static void main(String[] args) {

        if (args.length > 0) {

            try {

                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to merge sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        mergeSortLarge(fileArray, 0, fileArray.length);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        mergeSortSmall(fileArray, 0, fileArray.length);
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

    public static void mergeSortLarge(int[] arr, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int midpoint = (start + end) / 2;

        mergeSortLarge(arr, start, midpoint);
        mergeSortLarge(arr, midpoint, end);

        mergeLarge(arr, start, midpoint, end);
    }

    public static void mergeSortSmall(int[] arr, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int midpoint = (start + end) / 2;

        mergeSortSmall(arr, start, midpoint);
        mergeSortSmall(arr, midpoint, end);

        mergeSmall(arr, start, midpoint, end);
    }

    public static void mergeLarge(int[] arr, int start, int mid, int end) {

        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);
    }

    public static void mergeSmall(int[] arr, int start, int mid, int end) {

        if (arr[mid - 1] >= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = arr[i] >= arr[j] ? arr[i++] : arr[j++];
        }

        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);
    }

}
