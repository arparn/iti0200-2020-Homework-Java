package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Hoody", BigDecimal.ONE, BigDecimal.valueOf(100), BigDecimal.valueOf(150));
    }

    @Test
    void getProductDescription() {
        assertEquals("Hoody 150 € 1 kg", product.getProductDescription());
    }

    @Test
    void getName() {
        assertEquals("Hoody", product.getName());
    }

    @Test
    void setName() {
        product.setName("TicWatch");
        assertEquals("TicWatch", product.getName());
    }

    @Test
    void getWeight() {
        assertEquals(BigDecimal.ONE, product.getWeight());
    }

    @Test
    void setWeight() {
        product.setWeight(BigDecimal.valueOf(0.556));
        assertEquals(BigDecimal.valueOf(0.556), product.getWeight());
    }

    @Test
    void getNetPrice() {
        assertEquals(BigDecimal.valueOf(100), product.getNetPrice());
    }

    @Test
    void setNetPrice() {
        product.setNetPrice(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(200), product.getNetPrice());
    }

    @Test
    void getGrossPrice() {
        assertEquals(BigDecimal.valueOf(150), product.getGrossPrice());
    }

    @Test
    void setGrossPrice() {
        product.setGrossPrice(BigDecimal.valueOf(220));
        assertEquals(BigDecimal.valueOf(220), product.getGrossPrice());
    }

    @Test
    void getProfitabilityPercentage() {
        assertEquals(new BigDecimal("33.3400"), product.getProfitabilityPercentage());
    }
}