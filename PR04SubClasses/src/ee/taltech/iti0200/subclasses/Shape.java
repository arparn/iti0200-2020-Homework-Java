package ee.taltech.iti0200.subclasses;

import java.util.Optional;

public abstract class Shape {
    private Category category;
    private double size;
    private Integer number;

    public enum Category {
        BIG("Big"), MEDIUM("Medium"), SMALL("Small");
        private String category;
        public String getCurrentCategory() {
            return this.category;
        }
        Category(String category) {
            this.category = category;
        }
    }


    public Shape(Category category, double size) {
        this.category = category;
        this.size = size;
    }

    public abstract String draw();

    public abstract double calculateArea();

    public Optional<Integer> getNumber() {
        if (number != null) {
            return Optional.of(number);
        } else {
            return Optional.empty();
        }
    }

    public void putNumber(int newNumber) {
        number = newNumber;
    }

    public void clearNumber() {
        number = null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category newCategory) {
        category = newCategory;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double newSize) {
        size = newSize;
    }
}
