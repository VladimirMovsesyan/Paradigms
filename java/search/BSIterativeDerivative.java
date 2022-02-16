package search;

public class BSIterativeDerivative {
    // Pred: arr is sorted by asceding
    // Post: answer = k, where is array shift equals k && return answer
    protected int binarySearchIterative(int[] arr) {
        // Pred: true 
        // Post: left = -1
        int left = -1;

        // Pred: true
        // Post: right = arr.length - 1
        int right = arr.length - 1;


        // Inv: right > left && left >= -1 && right < arr.length && answer > left && answer <= right
        while (right - left > 1) {
            // Inv: right > left && left >= -1 && right < arr.length && answer > left && answer <= right

            // Pred: (left + right) / 2 >= 0 && (left + right) / 2 < arr.length
            // Post: mid = (left + right) / 2
            int mid = (left + right) / 2;

            // Pred: Inv && right - left > 1
            // Post: Inv
            if (arr[mid] >= arr[arr.length - 1]) {
                // arr[mid] >= arr[arr.length - 1] -> answer >= mid
                // Pred: mid = (left + right) / 2 && arr[mid] > arr[arr.length - 1] && right - left > 1 && Inv
                // Post: left = mid
                left = mid;
                // Inv: right > left && left >= -1 && right <= arr.length && answer > left && answer <= right
            } else {
                // arr[mid] < arr[arr.length] -> mid > answer
                // Pred: mid = (left + right) / 2 && arr[mid] < arr[arr.length - 1] && right - left > 1 && Inv
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
