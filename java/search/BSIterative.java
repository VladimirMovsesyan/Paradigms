package search;

public class BSIterative {
    // Pred: arr is sorted by desceding
    // Post: answer = (arr.length > 0 ? (ind, where arr[ind] = value) : arr.length) && ind = min(ind), where arr[ind] = value && return answer
    protected int binarySearchIterative(int[] arr, int val) {
        // Pred: true 
        // Post: left = -1
        int left = -1;

        // Pred: true
        // Post: right = arr.length
        int right = arr.length;


        // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right
        while (right - left > 1) {
            // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right

            // Pred: (left + right) / 2 >= 0 && (left + right) / 2 < arr.length
            // Post: mid = (left + right) / 2
            int mid = (left + right) / 2;

            // Pred: Inv && right - left > 1
            // Post: Inv
            if (arr[mid] > val) {
                // arr[mid] > val -> mid < answer
                // Pred: mid = (left + right) / 2 && arr[mid] > val && right - left > 1 && Inv
                left = mid;
                // Post: left = mid
                // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right
            } else {
                // arr[mid] <= val -> mid >= answer
                // Pred: mid = (left + right) / 2 && arr[mid] <= val && right - left > 1 && Inv
                // Post: right = mid
                right = mid;
                // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right
            }
            // Post: Inv
            // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right
        }
        // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right

        // Pred: right = answer
        // Post: return right
        return right;
    }
}
