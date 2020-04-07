package ee.taltech.iti0200.sum100;

public class Number implements MagicNumber {

    public short num;
    public boolean subtract;
    public boolean placeNext;

    public Number(short num, boolean subtract, boolean placeNext) {
        this.num = num;
        this.subtract = subtract;
        this.placeNext = placeNext;
    }

    @Override
    public short getNumber() {
        return this.num;
    }

    @Override
    public boolean canBeSubtracted() {
        return this.subtract;
    }

    @Override
    public boolean canBePlacedNextToOther() {
        return this.placeNext;
    }
}
