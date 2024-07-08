import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import SortFunctions.Utils;

//this class takes a filepath as a command line argument
//contents of the file must be integers or strings with same radix and width
//this program will use radix sort to arrange the file contents in order
//of smallest to largest, or largest to smallest
//time complexity is O(n)

public class RadixSort {

    public static void main(String[] args) {

        if (args.length > 0) {

            try {

                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to radix sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        radixLarge(fileArray, 10, 4);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        radixSmall(fileArray, 10, 4);
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

    public static void radixSmall(int[] arr, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }

        Utils.reverseArray(arr);
    }

    public static void radixLarge(int[] arr, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }
    }

    public static void radixSingleSort(int[] arr, int position, int radix) {
        int[] countArray = new int[radix];

        for (int value : arr) {
            countArray[getDigit(position, value, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[arr.length];

        for (int tempIndex = arr.length - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] = arr[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < arr.length; tempIndex++) {
            arr[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    // TODO: implement letter sorting
}
