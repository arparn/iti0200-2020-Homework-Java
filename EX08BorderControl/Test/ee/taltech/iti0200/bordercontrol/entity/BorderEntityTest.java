package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BorderEntityTest {

    public static final long NUMBER = 123434566;
    public static final long NUMBER2 = 1234578986;

    Goods goods = new Goods(NUMBER);
    Long goodsId = NUMBER;

    @Test
    void getName() {
        assertNull(goods.getName());
    }

    @Test
    void getBorderCrossingId() {
        assertEquals(goodsId, goods.getBorderCrossingId());
    }

    @Test
    void setBorderCrossingId() {
        goods.setBorderCrossingId(NUMBER2);
        assertEquals(NUMBER2, goods.getBorderCrossingId());
    }
}
