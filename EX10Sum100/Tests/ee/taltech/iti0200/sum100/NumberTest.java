package ee.taltech.iti0200.sum100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberTest {
    public static final int NUM1 = 1;
    Number number;

    @BeforeEach
    void setUp() {
        this.number = new Number((short) NUM1, false, true);
    }

    @Test
    void getNumber() {
        assertEquals(1, number.getNumber());
    }

    @Test
    void canBeSubtracted() {
        assertFalse(number.canBeSubtracted());
    }

    @Test
    void canBePlacedNextToOther() {
        assertTrue(number.canBePlacedNextToOther());
    }
}