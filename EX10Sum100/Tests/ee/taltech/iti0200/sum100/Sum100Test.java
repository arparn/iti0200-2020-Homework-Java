package ee.taltech.iti0200.sum100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Sum100Test {

    public static final int NUM1 = 1;
    public static final int NUM2 = 2;
    public static final int NUM3 = 3;
    public static final int NUM4 = 4;
    public static final int NUM5 = 5;
    public static final int NUM6 = 6;
    public static final int NUM7 = 7;
    public static final int NUM8 = 8;
    public static final int NUM9 = 9;

    Number number1;
    Number number2;
    Number number3;
    Number number4;
    Number number5;
    Number number6;
    Number number7;
    Number number8;
    Number number9;
    List<MagicNumber> testInput = new LinkedList<>();
    List<MagicNumber> testInput2 = new LinkedList<>();
    List<String> testRecursion = new LinkedList<>();
    List<String> testRecursionCorrect = new LinkedList<>();
    List<String> testCalcSumCorrect = new LinkedList<>();


    @BeforeEach
    void setUp() {
        this.number1 = new Number((short) NUM1, false, false);
        this.number2 = new Number((short) NUM2, false, false);
        this.number3 = new Number((short) NUM3, false, true);
        this.number4 = new Number((short) NUM4, true, false);
        this.number5 = new Number((short) NUM5, false, false);
        this.number6 = new Number((short) NUM6, false, true);
        this.number7 = new Number((short) NUM7, false, false);
        this.number8 = new Number((short) NUM8, false, false);
        this.number9 = new Number((short) NUM9, false, false);
        testInput.add(number1);
        testInput.add(number2);
        testInput.add(number3);
        testInput.add(number4);
        testInput.add(number5);
        testInput.add(number6);
        testInput.add(number7);
        testInput.add(number8);
        testInput.add(number9);
        this.number1 = new Number((short) NUM1, false, false);
        this.number2 = new Number((short) NUM2, false, false);
        this.number3 = new Number((short) NUM3, false, false);
        this.number4 = new Number((short) NUM4, true, false);
        this.number5 = new Number((short) NUM5, false, false);
        this.number6 = new Number((short) NUM6, false, false);
        this.number7 = new Number((short) NUM7, false, false);
        this.number8 = new Number((short) NUM8, false, true);
        this.number9 = new Number((short) NUM9, false, false);
        testInput2.add(number1);
        testInput2.add(number2);
        testInput2.add(number3);
        testInput2.add(number4);
        testInput2.add(number5);
        testInput2.add(number6);
        testInput2.add(number7);
        testInput2.add(number8);
        testInput2.add(number9);
        testRecursion.add("1+2+3-4+5+6+78+9");
        testRecursion.add("1-2-3-4+5+6+7+8+9");
        testRecursionCorrect.add("1+2+3-4+5+6+78+9");
        testCalcSumCorrect.add("1+23-4+56+7+8+9");
    }

    @Test
    void removeVariants() {
        assertEquals(testRecursionCorrect, Sum100.removeVariants(testRecursion));
    }

    @Test
    void calcSums() {
        assertEquals(testCalcSumCorrect, Sum100.calcSums(testInput));
    }

    @Test
    void testCalcSums() {
        assertEquals(testRecursionCorrect, Sum100.calcSums(testInput2));
    }
}
