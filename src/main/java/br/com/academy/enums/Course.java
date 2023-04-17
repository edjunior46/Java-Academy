package br.com.academy.enums;

public enum Course {
    MEDICINE("Medicine"),
    LAW("Law"),
    ARCHITECTURE("Architecture"),
    ENGINEERING("Engineering"),
    PHILOSOPHY("Philosophy"),
    JOURNALISM("Journalism");

    private String course;

    private Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
