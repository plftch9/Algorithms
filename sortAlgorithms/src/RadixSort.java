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
                System.out.println("Welcome to insertion sort program");
                System.out.println("1. Sort from small -> large");
                System.out.println("2. Sort from large -> small");

                int selection = input.nextInt();
                input.close();

                switch (selection) {
                    case 1:
                        // radixLarge(fileArray);
                        Utils.displayResults(fileArray);
                        break;

                    case 2:
                        // radixSmall(fileArray);
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

    public static void radixLarge() {

    }

    public static void radixSmall() {

    }

    // TODO: implement letter sorting
}
