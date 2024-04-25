package searchAlgorithms.src;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import searchAlgorithms.src.SearchFunctions.Utils;

//this class takes a filepath as command line argument
//contents of this file must be sorted integers
//this program will use binary search to find the index of a target value
//time complexity is O(log n)
public class BinarySearch {

    public static void main(String[] args) {
        if (args.length > 0) {
            int value;

            try {
                // File fileArg = new File(args[0]);
                int[] fileArray = Utils.loadArray(new File(args[0]));

                Scanner input = new Scanner(System.in);
                int[] choices = new int[2];
                System.out.println("Welcome to binary search program");
                System.out.println("Enter integer to search for");

                int selection = input.nextInt();
                choices[0] = selection;

                System.out.println("How would you like to search");
                System.out.println("1. Iteratively");
                System.out.println("2. Recursively");

                selection = input.nextInt();
                choices[1] = selection;
                input.close();

                switch (choices[1]) {
                    case 1:
                        value = iterativeSearch(fileArray, choices[0]);
                        if (value > -1) {
                            System.out.println(choices[0] + " is present in the array");
                            break;
                        } else {
                            System.out.println(choices[0] + " is not present in the array");
                            break;
                        }

                    case 2:
                        value = recursiveSearch(fileArray, choices[0]);
                        if (value > -1) {
                            System.out.println(choices[0] + " is present in the array");
                            break;
                        } else {
                            System.out.println(choices[0] + " is not present in the array");
                            break;
                        }

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

    public static int iterativeSearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length;
        int iterations = 1;

        while (start < end) {
            int midpoint = (start + end) / 2;
            System.out.println("Iteration: " + iterations);
            if (arr[midpoint] == value) {
                System.out.println("Index found during this iteration");
                return midpoint;
            } else if (arr[midpoint] < value) {
                iterations++;
                System.out.println("Next iteration will check right half");
                start = midpoint + 1;
            } else {
                iterations++;
                System.out.println("Next iteration will check left half");
                end = midpoint;
            }
        }

        return -1;
    }

    public static int recursiveSearch(int[] arr, int value) {
        return recursiveSearch(arr, 0, arr.length, value, 1);
    }

    public static int recursiveSearch(int[] arr, int start, int end, int value, int iterations) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.println("Function Calls: " + iterations);

        if (arr[midpoint] == value) {
            System.out.println("Index found during this function call");
            return midpoint;
        } else if (arr[midpoint] < value) {
            System.out.println("Next function call will check right half");
            return recursiveSearch(arr, midpoint + 1, end, value, iterations + 1);
        } else {
            System.out.println("Next function call will check left half");
            return recursiveSearch(arr, start, midpoint, value, iterations + 1);
        }
    }
}