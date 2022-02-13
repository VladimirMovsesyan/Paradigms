package search;

public class BSRecursive {
    // Pred: arr is sorted by desceding
    // Post: answer = (arr.length > 0 ? (ind, where arr[ind] = value) : arr.length) && ind = min(ind), where arr[ind] = value && return answer
    protected int BinarySearchRecursive(int[] arr, int val) {
        return BinarySearchRecursive(arr, val, -1, arr.length);
    }


    // Pred: arr is sorted by desceding && l >= -1 && arr.length >= r && l < r && answer is between l and r
    // Post: answer = (arr.length > 0 ? (ind, where arr[ind] = value) : arr.length) && ind = min(ind), where arr[ind] = value && return answer
    protected int BinarySearchRecursive(int[] arr, int val, int l, int r) {
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
            int temp = 0;

            // Pred: r - l > 1 && mid between l and r
            // Post: temp = answer
            if (arr[mid] > val) {
                // arr[mid] > val -> mid < answer
                // Pred: answer between mid and r && arr is sorted by desceding && l >= -1 && arr.length >= r && l < r && answer is between l and r
                // Post: temp = answer
                temp = BinarySearchRecursive(arr, val, mid, r);
            } else {
                // arr[mid] <= val -> mid >= answer
                // Pred: answer between l and mid && arr is sorted by desceding && l >= -1 && arr.length >= r && l < r && answer is between l and r
                // Post: temp = answer
                temp = BinarySearchRecursive(arr, val, l, mid);
            }

            // Pred: temp = answer
            // Post: return answer
            return temp;
        }
    }
}
