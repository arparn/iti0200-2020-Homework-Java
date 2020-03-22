package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BorderEntityTest {

    Goods goods = new Goods((long) 123434566);
    Long goodsId = (long) 123434566;

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
        goods.setBorderCrossingId((long) 1234578986);
        assertEquals((long) 1234578986, goods.getBorderCrossingId());
    }
}
