package ait.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (this.isEmailValid(email)) {
            this.email = email;
        } else {
            System.out.println(email + " invalid");
        }

    }

    private boolean isEmailValid(String email) {
        int indexAt = email.indexOf(64);
        if (indexAt != -1 && email.indexOf(64, indexAt + 1) < 0) {
            if (email.indexOf(46, indexAt) == -1) {
                return false;
            } else if (email.lastIndexOf(46) > email.length() - 3) {
                return false;
            } else {
                for(int i = 0; i < email.length(); ++i) {
                    char c = email.charAt(i);
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != '_' && c != '-' && c != '.' && c != '@') {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (this.isPasswordValid(password)) {
            this.password = password;
        } else {
            System.out.println("Password invalid");
        }

    }

    private boolean isPasswordValid(String password) {
        boolean[] condition = new boolean[5];
        if (password.length() >= 8) {
            condition[0] = true;
        }

        for(int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                condition[1] = true;
            }

            if (Character.isUpperCase(c)) {
                condition[2] = true;
            }

            if (Character.isLowerCase(c)) {
                condition[3] = true;
            }

            if (c == '!' || c == '%' || c == '@' || c == '$' || c == '&') {
                condition[4] = true;
            }
        }

        return condition[0] && condition[1] && condition[2] && condition[3] && condition[4];
    }

    public String toString() {
        return "User{email='" + this.email + "', password='" + this.password + "'}";
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && this.getClass() == object.getClass()) {
            User user = (User)object;
            return this.email.equals(user.email);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.email.hashCode();
    }
}
