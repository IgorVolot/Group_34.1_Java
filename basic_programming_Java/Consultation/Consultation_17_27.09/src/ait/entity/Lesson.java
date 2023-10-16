package ait.entity;

public class Lesson {
    private int id;
    private String plan;
    private String theory;
    private String homeWork;
    private String code;

    public Lesson(int id, String plan, String theory, String homeWork, String code) {
        this.id = id;
        this.plan = plan;
        this.theory = theory;
        this.homeWork = homeWork;
        this.code = code;
    }

    public void displayLessonDetails() {
        System.out.println("Id: " + this.id
                + " plan: " + this.plan
                + " theory: " + this.theory
                + " homework " + this.homeWork
                + " code " + this.code);
    }
    public int getId(){
        return this.id;
    }
}
