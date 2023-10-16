public class ArrayAppl {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int[] arr = new int[5];
        System.out.println(arr[2]);
        arr[2] = 100500;
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        arr[3] = arr[2] * 5;
        System.out.println(arr[3]);
        System.out.println(arr[0]);
        System.out.println(arr.length);
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(primes);
        System.out.println(primes.length);
        System.out.println(primes[2]);
        int i = 4;
        System.out.println(primes[i]);
        i++;
        System.out.println(primes[i]);
        System.out.println("===================");
        printArray(primes);
        printArray(arr);
        int res = sumArray(primes);
        System.out.println("Sum = " + res);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i + "] = " + arr[i]);
        }
        System.out.println("===================");
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // sum = sum + arr[i];
        }
        return sum;
    }
}
