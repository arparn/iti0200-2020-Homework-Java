package ee.taltech.iti0200.subclasses;

public class Circle extends Shape {
    public Circle(Category category, double size) {
        super(category, size);
    }

    @Override
    public String draw() {
        String actualCategory = null;
        for (Category cat : Category.values()) {
            if (getCategory().toString().equals(cat.name())) {
                actualCategory = cat.getCurrentCategory();
                break;
            }
        }
        return "Drawing circle! Category: " + actualCategory;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (getSize() * getSize());
    }
}
