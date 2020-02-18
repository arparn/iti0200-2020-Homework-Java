package ee.taltech.iti0200.subclasses;
public class Square extends Shape {
    public Square(Category category, double size) {
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
        return "Drawing square! Category: " + actualCategory;
    }

    @Override
    public double calculateArea() {
        return getSize() * getSize();
    }
}
