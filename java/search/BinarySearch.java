package search;

public class BinarySearch {

    // Pred: args.length > 0 && forAll args[i] is number
    // Post: answer printed
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        int[] arr = new int[args.length - 1];
        
        int ind = 1;

        // Pred: arr.length > 0
        // Post: arr[ind - 1] = Integer.parseInt(args[ind]) && forAll (ind >= 1 && ind < args.length)
        while (ind < args.length) {

            // Pred: ind >= 1 && ind < args.length
            // Post: arr[ind - 1] = Integer.parseInt(args[ind])
            arr[ind - 1] = Integer.parseInt(args[ind]);

            // Pred: ind < args.length
            // Post: ind' = ind + 1
            ind++;
        }

        BSIterative binSearch = new BSIterative();

        // Pred: arr is forAll arr[i], where i > 0 and i < n arr[i] <= arr[i - 1]
        // Post: answer = (arr.length > 0 ? (ind, where arr[ind] = value) : arr.length) && ind = min(ind), where arr[ind] = value
        int answer = binSearch.binarySearchIterative(arr, x);

        System.out.println(answer);
    }
}
