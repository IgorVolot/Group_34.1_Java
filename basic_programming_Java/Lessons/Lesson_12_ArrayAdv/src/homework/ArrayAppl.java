package homework;

public class ArrayAppl {
    public static void main(String[] args) {

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        printReverseArray(primes);
        int res = sumOddArray(primes);
        System.out.println("Sum = " + res);
        res = multiplyEvenIndexArray(primes);
        System.out.println("Multiply = " + res);
    }

    public static void printReverseArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("[" + i + "] = " + arr[i]);
        }
        System.out.println("===================");
    }

    public static int sumOddArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sum += arr[i]; // sum = sum + arr[i];
            }
        }
        return sum;
    }

    public static int multiplyEvenIndexArray(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                res *= arr[i]; // res = res * arr[i];
            }
        }
        return res;
    }
}
