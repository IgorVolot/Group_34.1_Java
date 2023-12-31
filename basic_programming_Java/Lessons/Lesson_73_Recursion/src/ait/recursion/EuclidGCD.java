package ait.recursion;
/*
    НОД по алгоритму Евклида;

    Наибольший общий делитель (НОД) двух чисел - это наибольшее число, которое делит оба числа без остатка. НОД имеет несколько важных применений в математике и информатике:
    1. **Упрощение дробей:** НОД числителя и знаменателя дроби позволяет сократить дробь до наименьших целых чисел. Например, для дроби 12/18 НОД(12, 18) равен 6, поэтому эту дробь можно упростить до 2/3, разделив числитель и знаменатель на 6.
    2. **Решение уравнений и поиска делимости:** НОД используется для решения уравнений и проверки делимости. Например, если НОД(15, 25) равен 5, это означает, что 5 является наибольшим числом, которое делит оба числа без остатка.
    3. **Алгоритмы и криптография:** НОД используется в различных алгоритмах, таких как RSA (алгоритм шифрования), где знание НОД двух чисел является важной частью процесса шифрования и дешифрования.
    4. **Оптимизация алгоритмов:** НОД используется в оптимизации алгоритмов, например, в алгоритме Евклида для нахождения НОД, который имеет множество применений в математике и компьютерных науках.
    НОД является важным математическим понятием, которое находит свое применение во многих областях, включая арифметику, алгоритмы, криптографию и другие области науки и техники.
 */
public class EuclidGCD {
    public static void main(String[] args) {
        int m = 12345;
        int n = 98765;
        int res = greatCommonDivision(m, n);
        System.out.println("GCD = " + res);
    }

    private static int greatCommonDivision(int m, int n) {
        if (m == n) {
            return n;
        }
        if (m > n) {
            return greatCommonDivision(m - n, n);
        } else {
            return greatCommonDivision(n - m, m);
        }
    }
}
