package ee.taltech.iti0200.sum100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicNumberTest {
    public static final int NUM1 = 2;
    Number number = new Number((short) NUM1, false, false);

    @Test
    void getNumber() {
        assertEquals(NUM1, number.getNumber());
    }

    @Test
    void canBeSubtracted() {
        assertFalse(number.canBeSubtracted());
    }

    @Test
    void canBePlacedNextToOther() {
        assertFalse(number.canBePlacedNextToOther());
    }
}