package search;

public class BSRecursive {
    protected int BinarySearchRecursive(int[] arr, int val) {
        return BinarySearchRecursive(arr, val, -1, arr.length);
    }

    private int BinarySearchRecursive(int[] arr, int val, int l, int r) {
        if (r - l <= 1) {
            return r;
        }

        int mid = (r + l) / 2;

        if (arr[mid] > val) {
            return BinarySearchRecursive(arr, val, mid, r);
        } else {
            return BinarySearchRecursive(arr, val, l, mid);
        }
    }
}
