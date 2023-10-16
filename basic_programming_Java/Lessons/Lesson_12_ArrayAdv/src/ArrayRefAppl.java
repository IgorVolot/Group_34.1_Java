public class ArrayRefAppl {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("a before = " + a);
        pow2Var(a);
        System.out.println("a after = " + a);
        int[] arr = {1, 2, 3}; //arr.length
        System.out.println(arr);
        System.out.println("arr[1] before = " + arr[1]);
        pow2Arr(arr);
        System.out.println("arr[1] after = " + arr[1]);
    }

    public static void pow2Arr(int[] arr) {
        arr[1] = arr[1] * arr[1];
        System.out.println("arr[1] in method = " + arr[1]);
    }

    public static void pow2Var(int a) {
        a = a * a;
        System.out.println("a in method = " + a);
    }
}
