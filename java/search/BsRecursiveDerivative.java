package search;

public class BSRecursiveDerivative {
    // Pred: arr is sorted by asceding and shifted for k
    // Post: answer = k, where is array shift equals k && return answer
    protected int BinarySearchRecursive(int[] arr) {
        return BinarySearchRecursive(arr, -1, arr.length);
    }


    // Pred: arr is sorted by asceding and shifted for k && l >= -1 && arr.length >= r && l < r && answer is between l and r
    // Post: answer = k, where is array shift equals k && return answer
    protected int BinarySearchRecursive(int[] arr, int l, int r) {
        // Pred: r - l >= 1 && answer between l and r
        // Post: answer between l and r && return r
        if (r - l == 1) {
            // Pred: answer - left == 1
            // Post: answer = r
            return r;
        } else {
            // Pred: r - l > 1
            // Post: answer between l and r

            // Pred: r + l >= 0
            // Post: mid = (r + l) / 2
            int mid = (r + l) / 2;


            // Pred: true
            // Post: temp = 0
            int temp;

            // Pred: r - l > 1 && mid between l and r
            // Post: temp = answer
            if (arr[mid] > arr[arr.length - 1]) {
                // arr[mid] > arr[arr.length - 1] -> mid < answer
                // Pred: answer between mid and r && arr is sorted by asceding and shifted for k && l >= -1 && arr.length >= r && l < r && answer is between l and r
                // Post: temp = answer
                temp = BinarySearchRecursive(arr, mid, r);
            } else {
                // arr[mid] <= arr[arr.length - 1] -> mid >= answer
                // Pred: answer between l and mid && arr is sorted by asceding && l >= -1 && arr.length >= r && l < r && answer is between l and r
                // Post: temp = answer
                temp = BinarySearchRecursive(arr, l, mid);
            }

            // Pred: temp = answer
            // Post: return answer
            return temp;
        }
    }
}
