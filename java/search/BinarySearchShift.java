package search;

public class BinarySearchShift {

    // Pred: args.length > 0 && forAll args[i] is number
    // Post: shift of array printed
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        
        int ind = 0;

        // Pred: arr.length > 0
        // Post: arr[ind] = Integer.parseInt(args[ind]) && forAll (ind >= 0 && ind < args.length)
        while (ind < args.length) {
            // Pred: ind >= 0 && ind < args.length
            // Post: arr[ind] = Integer.parseInt(args[ind])
            arr[ind] = Integer.parseInt(args[ind]);

            // Pred: ind < args.length
            // Post: [cur]ind = [cur]ind + 1
            ind++;
        }

        BSRecursiveDerivative binSearch = new BSRecursiveDerivative();

        // Pred: arr.length > 0 && forAll arr[i], where i > 0 and i < n arr[i] > arr[i - 1] and shifted for k, where k >= 0
        // Post: answer = k
        int answer = binSearch.BinarySearchRecursive(arr);

        System.out.println(answer);
    }
}
