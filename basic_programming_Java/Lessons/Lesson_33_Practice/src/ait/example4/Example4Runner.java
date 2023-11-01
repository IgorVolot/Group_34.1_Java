package ait.example4;

public class Example4Runner {

    public static void main(String[] args) {
        User userVasja = new User("Vasja", "Pupkin");
        User userVasja2 = new User("Vasja", "Pupkin-2");
        User unserMarina = new User("Marina", "Pupkin");

        System.out.println(userVasja == userVasja); // true
        System.out.println(userVasja == userVasja2); // fasle

        System.out.println(userVasja.equals(userVasja2)); // false
    }
}
