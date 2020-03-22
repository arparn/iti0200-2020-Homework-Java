package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class GoodsTest {

    Goods item;
    Long productId;

    @BeforeEach
    void setUp() {
        this.item = new Goods((long) 1002394);
        this.productId = (long) 1002394;
    }

    @Test
    void getProductId() {
        assertEquals(productId, item.getProductId());
    }

    @Test
    void getName() {
        assertNull(item.getName());
    }

    @Test
    void getBorderCrossingId() {
        assertEquals(productId, item.getBorderCrossingId());
    }

    @Test
    void setBorderCrossingId() {
        productId = (long) 123457;
        item.setBorderCrossingId(productId);
        assertEquals(productId, item.getBorderCrossingId());
    }
}
