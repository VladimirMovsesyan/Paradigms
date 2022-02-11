package search;

import java.util.Arrays;

public class BinarySearch {

    public static int[] parse(String inputTest) {
        int[] arr = new int[10];
        int length = 0;

        for (int i = 0; i < inputTest.length(); i++) {
            StringBuilder curDigit = new StringBuilder();

            while (i < inputTest.length() && Character.isWhitespace(inputTest.charAt(i))) {
                i++;
            }

            while (i < inputTest.length() && (Character.isDigit(inputTest.charAt(i)) || inputTest.charAt(i) == '-')) {
                curDigit.append(inputTest.charAt(i));
                i++;
            }

            if (curDigit.length() > 0) {
                if (arr.length == length) {
                    arr = Arrays.copyOf(arr, arr.length * 2);
                }

                arr[length++] = Integer.parseInt(curDigit.toString());
            }
        }

        arr = Arrays.copyOf(arr, length);

        return arr;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] arr = new int[args.length - 1];
        
        for (int i = 1; i < args.length; i++) {
            arr[i - 1] = Integer.parseInt(args[i]);
        }

        // int[] arr = parse(temp.toString());
        
        // BSRecursive binSearch = new BSRecursive();
        // System.out.println(binSearch.BinarySearchRecursive(arr, x));

        BSIterative binSearch = new BSIterative();
        System.out.println(binSearch.binarySearchIterative(arr, x));
        
    }
}
