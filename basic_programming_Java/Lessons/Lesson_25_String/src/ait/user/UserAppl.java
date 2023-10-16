package ait.user;

import ait.user.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User("peter@gmx.de", "qweRTY1234@");
        System.out.println(user);
        user.setEmail("peter@web.de");
        user.setPassword("Qwerty1234!");
        System.out.println(user);
    }
}
