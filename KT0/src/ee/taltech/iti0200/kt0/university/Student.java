package ee.taltech.iti0200.kt0.university;

public class Student {

    private String name;
    private int eap;


    public Student(String name) {
        this.name = name;
        this.eap = 0;
    }

    public String getName() {
        return name;
    }

    public int getEap() {
        return eap;
    }

    public void setEap(int newEap) {
        this.eap = newEap;
    }

    public String toString() {
        return name + " (" + eap + ")";
    }
}
