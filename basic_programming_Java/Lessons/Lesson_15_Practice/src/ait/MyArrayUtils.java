package ait;

import java.util.Arrays;

/**
 * @author Andrej Reutow
 * created on 25.09.2023
 */

//поиск элемента массива;
//добавление нового элемента (в начало, в конец, в середину);
//редактирование(изменение) элемента массива;
//удаление элемента массива;
//поиск максимального/минимального значения;
//сортировка по возрастанию/убыванию;
//удаление дубликатов;
//сдвиг массива;
public class MyArrayUtils {

    public static void main(String[] args) {
        int[] testArray = {1, 10, 1111082, -5, 20, 1111082, 1, 10, 1, 1};

        int findIndex = findIndexByElement(testArray, 1111082);
        System.out.println(findIndex);

        if (findIndex >= 0) {
            System.out.println("Element is found");
        } else {
            System.out.println("Element not found");
        }

        findIndex = findIndexByElementN(testArray, 1, 4);
        System.out.println("4 " + findIndex); // 9

        findIndex = findIndexByElementN(testArray, 1, 2);
        System.out.println("2 " + findIndex); // 6

        findIndex = findIndexByElementN(testArray, 1, 100);
        System.out.println("100 " + findIndex); // -1

        findIndex = findIndexByElementN(testArray, 7777, 1);
        System.out.println("1 " + findIndex); // -1


        System.out.println(Arrays.toString(testArray));
        removeElement(testArray, testArray.length - 1);

        int maxElement = findMaxElement(testArray);
        System.out.println(maxElement);

        int minElement = findMinElement(testArray);
        System.out.println(minElement);
    }

    /**
     * @param sourceArr   исходный мсассив
     * @param searchValue значение для поиска в массиве
     * @return индекс найденного значения. Если значение не найдено возвращает -1
     */
    public static int findIndexByElement(int[] sourceArr, int searchValue) {
        int elementIndex = -1;
        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] == searchValue) {
//                return i;
                elementIndex = i;
                break;
            }
        }

        return elementIndex;
    }


    /**
     * @param sourceArr   исходный мсассив
     * @param searchValue значение для поиска в массиве
     * @param n           количесвто вхождений искомого элемента в массив
     * @return индекс найденного значения. Если значение не найдено возвращает -1
     */
    public static int findIndexByElementN(int[] sourceArr, int searchValue, int n) {
        int couter = 0;

        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] == searchValue) {
                couter++;
                if (couter == n) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * добавление нового элемента;
     *
     * @param sourceArr исходный мсассив
     * @param index     индекс для вставки элемента
     * @param value     значение для вставки по index
     */
    public static void setElement(int[] sourceArr, int index, int value) {
        sourceArr[index] = value;
    }

    /**
     * @param sourceArr исходный мсассив
     * @param index     индекс для изменения элемента
     * @param value     значение
     */
    //редактирование(изменение) элемента массива;
    public static void editElement(int[] sourceArr, int index, int value) {
        setElement(sourceArr, index, value);
    }

    // удалить элемент по индексу - установить значение по умолчанию
    public static void removeElement(int[] sourceArr, int index) {
        // sourceArr[index] = 0;
        setElement(sourceArr, index, 0);
    }

    // нужно вернуть максимальный элемент в массиве
    public static int findMaxElement(int[] sourceArr) {
        int maxValue = sourceArr[0];

        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] > maxValue) {
                maxValue = sourceArr[i];
            }
        }
        // maxValue , elmt array,  sourceArr[i] > maxValue
        // 1, 1                  1 > 1
        // 1, 10                 10 > 1
        // 10, 1111082           1111082 > 10
        // 1111082, -5           -5 > 1111082
        // 1111082, 20           20 > 1111082
        // 1111082, 1111082      1111082 > 1111082
        // 1111082, 1            1 > 1111082

        return maxValue;
    }

    // нужно вернуть максимальный элемент в массиве
    public static int findMinElement(int[] sourceArr) {
        int minElement = sourceArr[0];

        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] < minElement) {
                minElement = sourceArr[i];
            }
        }

        return minElement;
    }

    public static void sortAz(int[] sourceArr) {
        //todo
    }

    public static void sortZa(int[] sourceArr) {
        //todo
    }

    //удалить из массива одинаковые элементы - установить значения по умолчанию
    public static void deleteDuplicate(int[] sourceArr) {
        //todo
    }
}
