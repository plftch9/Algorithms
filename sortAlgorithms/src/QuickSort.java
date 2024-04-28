import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers
//this program will use quick sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n log n)
public class QuickSort {

    public static void main(String[] args) {
        if (args.length > 0) {

            try {

                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to quick sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        quickSortLarge(fileArray, 0, fileArray.length);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        quickSortSmall(fileArray, 0, fileArray.length);
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

    public static void quickSortLarge(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partitionLarge(arr, start, end);
        quickSortLarge(arr, start, pivotIndex);
        quickSortLarge(arr, pivotIndex + 1, end);
    }

    public static void quickSortSmall(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partitionSmall(arr, start, end);
        quickSortSmall(arr, start, pivotIndex);
        quickSortSmall(arr, pivotIndex + 1, end);
    }

    public static int partitionLarge(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[--j] >= pivot)
                ;
            if (1 < j) {
                arr[i] = arr[j];
            }

            while (i < j && arr[++i] <= pivot)
                ;
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;
        return j;
    }

    public static int partitionSmall(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[--j] <= pivot)
                ;
            if (1 < j) {
                arr[i] = arr[j];
            }

            while (i < j && arr[++i] >= pivot)
                ;
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;
        return j;
    }

}
