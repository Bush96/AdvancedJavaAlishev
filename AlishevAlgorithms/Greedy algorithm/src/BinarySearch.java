public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {2, 5, 6, 9, 12, 43, 54};

        System.out.println(binarySearch(a,5));
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;            //middle = low + (high - low) / 2; - статичная формула поиска центра массива
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
