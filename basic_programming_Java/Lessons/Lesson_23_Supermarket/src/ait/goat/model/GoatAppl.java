package ait.goat.model;

public class GoatAppl {
    public static final int COUNT_MAX = 100;
    private int count;
    private final String name;

    public GoatAppl(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public void increment() {
        ++this.count;
    }

    public String toString() {
        return "Goat{count=" + this.count + ", name='" + this.name + "'}";
    }
}
