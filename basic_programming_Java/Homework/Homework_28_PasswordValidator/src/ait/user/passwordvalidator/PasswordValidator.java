package ait.user.passwordvalidator;

public class PasswordValidator {
    private final int minLowerCase;
    private final int minUpperCase;
    private final int minDigits;
    private final int minLength;
    private final String symbolList;
    private final int minSymbolCount;

    public PasswordValidator(int minLowerCase, int minUpperCase, int minDigits, int minLength, String symbolList, int minSymbolCount) {
        this.minLowerCase = minLowerCase;
        this.minUpperCase = minUpperCase;
        this.minDigits = minDigits;
        this.minLength = minLength;
        this.symbolList = symbolList;
        this.minSymbolCount = minSymbolCount;
    }

    public boolean isPasswordValid(String password) {
        boolean[] condition = new boolean[5];
        if (password.length() >= this.minLength) {
            condition[0] = true;
        }

        int digitCounter = 0;
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int symbolCounter = 0;

        for(int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (Character.isDigit(c) && password.indexOf(c) >= 0) {
                ++digitCounter;
            }

            if (digitCounter >= this.minDigits) {
                condition[1] = true;
            }

            if (Character.isUpperCase(c) && password.indexOf(c) >= 0) {
                ++upperCaseCounter;
            }

            if (upperCaseCounter >= this.minUpperCase) {
                condition[2] = true;
            }

            if (Character.isLowerCase(c) && password.indexOf(c) >= 0) {
                ++lowerCaseCounter;
            }

            if (lowerCaseCounter >= this.minLowerCase) {
                condition[3] = true;
            }

            if (this.symbolList.indexOf(c) >= 0) {
                ++symbolCounter;
            }

            if (symbolCounter >= this.minSymbolCount) {
                condition[4] = true;
            }
        }

        return condition[0] && condition[1] && condition[2] && condition[3] && condition[4];
    }

    public boolean isValid(String password) {
        return this.isDigitsContains(password) && this.isLowerCaseContains(password) && this.isUpperCaseContains(password) && this.isSymbolsContains(password) && this.isLengthValid(password);
    }

    public boolean isDigitsContains(String password) {
        int counter = 0;

        for(int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (Character.isDigit(c) && password.indexOf(c) >= 0) {
                ++counter;
            }

            if (counter >= this.minDigits) {
                return true;
            }
        }

        return false;
    }

    public boolean isSymbolsContains(String password) {
        int counter = 0;

        for(int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (this.symbolList.indexOf(c) >= 0) {
                ++counter;
            }

            if (counter >= this.minSymbolCount) {
                return true;
            }
        }

        return false;
    }

    public boolean isUpperCaseContains(String password) {
        int counter = 0;

        for(int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c) && password.indexOf(c) >= 0) {
                ++counter;
            }

            if (counter >= this.minUpperCase) {
                return true;
            }
        }

        return false;
    }

    public boolean isLowerCaseContains(String password) {
        int counter = 0;

        for(int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c) && password.indexOf(c) >= 0) {
                ++counter;
            }

            if (counter >= this.minLowerCase) {
                return true;
            }
        }

        return false;
    }

    public boolean isLengthValid(String password) {
        return password.length() >= this.minLength;
    }
}
