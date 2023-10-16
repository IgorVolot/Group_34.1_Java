public class ArraySortAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];
        fillArray(arr, 10, 99);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
        int index = binarySearch(arr, 105);
        System.out.println("Index = " + index);

    }

    public static int binarySearch(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (value > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -l - 1;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (min + Math.random() * (max + 1 - min));
        }
    }
}
