package SortFunctions;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Utils {

    // this function swaps the values of 2 indexes with each other
    public static void valueSwap(int[] arr, int index1, int index2) {

        if (index1 == index2) {
            return;
        }

        int indexVal = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = indexVal;
    }

    public static int[] loadArray(File file) throws FileNotFoundException {
        List<Integer> numArrayList = new ArrayList<Integer>();
        Scanner fileScan = new Scanner(file);
        try {

            while (fileScan.hasNextInt()) {
                numArrayList.add(fileScan.nextInt());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            fileScan.close();
        }
        fileScan.close();

        int[] numArray = new int[numArrayList.size()];
        for (int i = 0; i < numArrayList.size(); i++) {
            numArray[i] = numArrayList.get(i);
        }
        return numArray;
    }

    public static void displayResults(int[] arr) {
        System.out.println("Sort Results:\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] getMinMax(int[] arr) {
        int[] minMax = new int[2];
        for (int in = 0; in < arr.length; in++) {
            if (minMax[0] < arr[in]) {
                minMax[0] = arr[in];
            }
            if (minMax[1] > arr[in]) {
                minMax[1] = arr[in];
            }

        }

        return minMax;
    }

    public static void reverseArray(int[] arr) {
        int temp;

        for (int i = 0; i < (int) arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
