package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class GoodsTest {
    public static final long NUMBER = 1002394;
    public static final long NUMBER2 = 123457;

    Goods item;
    Long productId;

    @BeforeEach
    void setUp() {
        this.item = new Goods(NUMBER);
        this.productId = NUMBER;
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
        productId = NUMBER2;
        item.setBorderCrossingId(productId);
        assertEquals(productId, item.getBorderCrossingId());
    }
}
