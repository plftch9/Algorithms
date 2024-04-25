package searchAlgorithms.src.SearchFunctions;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Utils {
    public static int[] loadArray(File file) throws FileNotFoundException {

        Scanner fileScan = new Scanner(file);
        int[] numArray = new int[10];
        int i = 0;
        try {
            while (fileScan.hasNextInt()) {
                numArray[i] = fileScan.nextInt();
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        fileScan.close();

        return numArray;
    }

    public static void displayResults(int[] arr) {
        System.out.println("Sort Results:\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
