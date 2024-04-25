package searchAlgorithms.src;

//this class takes a filepath as command line argument
//contents of this file must be sorted integers
//this program will use binary search to find the index of a target value
//time complexity is O(log n)
public class BinarySearch {

    public static void main(String[] args) {

    }

    public static int iterativeSearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length;

        while (start > end) {
            int midpoint = (start + end) / 2;
            if (arr[midpoint] == value) {
                return midpoint;
            } else if (arr[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }

        return -1;
    }

    public static int recursiveSearch(int[] arr, int value) {
        return recursiveSearch(arr, 0, arr.length, value);
    }

    public static int recursiveSearch(int[] arr, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;

        if (arr[midpoint] == value) {
            return midpoint;
        } else if (arr[midpoint] < value) {
            return recursiveSearch(arr, midpoint + 1, end, value);
        } else {
            return recursiveSearch(arr, start, midpoint, value);
        }
    }
}