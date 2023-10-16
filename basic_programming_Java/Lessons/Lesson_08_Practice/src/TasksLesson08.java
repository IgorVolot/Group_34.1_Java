/**
 * @author Andrej Reutow
 * created on 14.09.2023
 */
public class TasksLesson08 {

    public static void main(String[] args) {
        System.out.println("- Task 1:");
        // позитивные случаи
        task1(1);       // Эконом
        task1(500);     // Стандарт
        task1(3000);    // Премиум
        // негативные случаи
        task1(-1);      // для вашего запроса нет тарифа
        task1(0);       // для вашего запроса нет тарифа
        System.out.println("====================================");
        System.out.println("- Task 2:");
        // позитивные случаи
        task2(1);           // ночь
        task2(12);          // утро
        task2(21);          // вечер
        // негативные случаи
        task2(25);          // сутки 24 часа, от 0 - до 23
        task2(-5);          // сутки 24 часа, от 0 - до 23
        System.out.println("=============FINISH=================");
    }

    /*
    Определение тарифа для мобильной связи (if-else-if-else) Оператор мобильной связи предлагает
    три тарифа: "Эконом", "Стандарт" и "Премиум".
    Если клиент использует менее 500 минут в месяц, ему подходит "Эконом".
    Если от 500 до 1000 минут — "Стандарт". Если больше 1000 минут — "Премиум".
    Программа должна принимать количество минут и выводить подходящий тариф.
     */
    public static void task1(int minMinutes) {

        if (minMinutes > 0 && minMinutes < 500) {
            System.out.println("Эконом");
        } else if (minMinutes >= 500 && minMinutes <= 1000) {
            System.out.println("Стандарт");
        } else if (minMinutes > 1000) {
            System.out.println("Премиум");
        } else {
            System.out.println("для вашего запроса нет тарифа");
        }
    }

    /*
    Определение времени суток (if-else-if-else) Напишите программу,
    которая принимает текущий час (от 0 до 23) и выводит приветствие в зависимости
    от времени суток(утро, день, вечер, ночь).
     */
    public static void task2(int hour) {

        // if (minMinute >= 500 && minMinute <= 1000)
        // если текущий час больше или равен 5
        // if hour >= 5
        // и текущий час меньше или равен 12
        if (hour >= 0 && hour <= 23) {
            // 5 .. 12
            if (hour >= 5 && hour <= 12) {
                System.out.println("утро");
            }

            // 13 ... 16
            if (hour >= 13 && hour <= 16) {
                System.out.println("день");
            }

            // 17 ... 21
            if (hour >= 17 && hour <= 21) {
                System.out.println("вечер");
            }

            // 22, 23 ...или 0 ... 4
            if ((hour == 22 || hour == 23) || (hour >= 0 && hour <= 4)) {
                System.out.println("ночь");
            }
        } else {
            System.out.println("сутки 24 часа, от 0 - до 23");
        }


//        if (hour >= 0 && hour <= 23) {
//
//            if (hour >= 5 && hour <= 12) {
//                System.out.println("утро");
//            } else if (hour >= 13 && hour <= 16) {
//                System.out.println("день");
//            } else if (hour >= 17 && hour <= 21) {
//                System.out.println("вечер");
//            } else {
//                System.out.println("ночь");
//            }
//
//        } else {
//            System.out.println("сутки 24 часа, от 0 - до 23");
//        }
    }
}