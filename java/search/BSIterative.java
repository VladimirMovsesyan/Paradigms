package search;

public class BSIterative {
    protected int binarySearchIterative(int[] arr, int val) {
        // Pred: 
        int left = -1;
        // Post: 
        int right = arr.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (arr[mid] > val) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
