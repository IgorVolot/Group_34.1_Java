public class NestedLoop {
    public static void main(String[] args) {
//        pithagoras();
        figure1(8);
    }

    public static void pithagoras() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void figure(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
    }

    public static void figure1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
