package ait.entity;

public class Main {
    public static void main(String[] args) {
        Lesson lesson01 = new Lesson(1, "OOP - part1", "OOP - part1 it is ...", "learn OOP - part1", "code - part1");
        Lesson lesson02 = new Lesson(2, "OOP - part2", "OOP - part2 it is ...", "learn OOP - part2", "code - part2");
        Lesson lesson03 = new Lesson(3, "OOP - part3", "OOP - part3 it is ...", "learn OOP - part3", "code - part3");
        Lesson lesson04 = new Lesson(4, "OOP - part4", "OOP - part4 it is ...", "learn OOP - part4", "code - part4");
        Lesson lesson05 = new Lesson(5, "OOP - part5", "OOP - part5 it is ...", "learn OOP - part5", "code - part5");

        lesson01.displayLessonDetails();
        lesson02.displayLessonDetails();
        lesson03.displayLessonDetails();
        lesson04.displayLessonDetails();
        lesson05.displayLessonDetails();

        Lesson[] array = new Lesson[10];
        array[0] = lesson01;
        array[1] = lesson02;
        array[2] = lesson03;
        array[3] = lesson04;
        array[4] = lesson05;
        System.out.println("-------------------------------------------------");

        Lesson foundlessonById = findLessonById(array, 7);
        foundlessonById.displayLessonDetails();

    }

    public static Lesson findLessonById(Lesson[] lessons, int idLesson) {
        for (int i = 0; i < lessons.length; i++) {
            if (null != lessons[i] && lessons[i].getId() == idLesson) {
                return lessons[i];
            }
        }
        return null;
    }
}
