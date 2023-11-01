package ait.example4;

public class User {

    private String name;
    private String lastName;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj != null && obj instanceof User) {
//            User otherUser = (User) obj;
//            return name.equals(otherUser.name);
//        }
//
//        return false;
//    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        return this.name.equals(user.name) &&
                this.lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}