public class OrderAgnosticBinarySearch {

    // Function to perform order-agnostic binary search
    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Check if the array is sorted in ascending or descending order
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            // Find the middle element
            int mid = start + (end - start) / 2;

            // Check if the target is found
            if (arr[mid] == target) {
                return mid;
            }

            // If array is sorted in ascending order
            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1; // Move left
                } else {
                    start = mid + 1; // Move right
                }
            } 
            // If array is sorted in descending order
            else {
                if (target > arr[mid]) {
                    end = mid - 1; // Move left
                } else {
                    start = mid + 1; // Move right
                }
            }
        }

        // If target is not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] ascendingArray = {1, 3, 5, 7, 9, 12, 15};
        int[] descendingArray = {15, 12, 9, 7, 5, 3, 1};

        int target = 9;

        // Search in ascending array
        int resultAsc = orderAgnosticBinarySearch(ascendingArray, target);
        System.out.println("Target found at index (ascending array): " + resultAsc);

        // Search in descending array
        int resultDesc = orderAgnosticBinarySearch(descendingArray, target);
        System.out.println("Target found at index (descending array): " + resultDesc);
    }
}



Explanation:
Order-Agnostic Search: The algorithm is called "order-agnostic" because it works on both ascending and descending sorted arrays. The key step is detecting whether the array is sorted in ascending or descending order by comparing the first and last elements.

If arr[start] < arr[end], the array is sorted in ascending order.
If arr[start] > arr[end], the array is sorted in descending order.
Binary Search:

Mid Calculation: We calculate the middle index using int mid = start + (end - start) / 2;. This avoids overflow when start + end is large.
Comparison:
If the element at mid is the target, we return mid.
If the array is in ascending order and the target is smaller than arr[mid], we search in the left half (end = mid - 1). Otherwise, we search in the right half (start = mid + 1).
If the array is in descending order, the conditions are inverted: we search left if the target is greater and right if the target is smaller.
Time Complexity: The time complexity of this algorithm is O(log n), where n is the number of elements in the array. This is because we divide the search space by half in every step, just like in standard binary search.
