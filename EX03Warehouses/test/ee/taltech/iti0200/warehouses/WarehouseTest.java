package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    Warehouse warehouse;
    Product product;
    Worker worker;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse("Akadeemia tee 7/1");
        product = new Product("Hoody", BigDecimal.ONE, BigDecimal.valueOf(100), BigDecimal.valueOf(150));
        worker = new Worker("Isac", "Clark", "50003103867", 75);
    }

    @Test
    void getAmount() {
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        warehouse.addProduct(entry);
        assertEquals((long) 100, warehouse.getAmount(product));
    }

    @Test
    void getAddress() {
        assertEquals("Akadeemia tee 7/1", warehouse.getAddress());
    }

    @Test
    void hasProduct() {
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        warehouse.addProduct(entry);
        assertTrue(warehouse.hasProduct(product));
    }

    @Test
    void hasEnoughProduct() {
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        warehouse.addProduct(entry);
        assertTrue(warehouse.hasEnoughProduct(product, (long) 100));
    }

    @Test
    void getWorkers() {
        HashSet<Worker> workerSet = new HashSet<>();
        workerSet.add(worker);
        warehouse.addWorker(worker);
        assertEquals(workerSet, warehouse.getWorkers());
    }

    @Test
    void addWorker() {
        HashSet<Worker> workerSet = new HashSet<>();
        workerSet.add(worker);
        warehouse.addWorker(worker);
        assertEquals(workerSet, warehouse.getWorkers());
    }

    @Test
    void getInventoryValue() {
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        warehouse.addProduct(entry);
        assertEquals(new BigDecimal("10000"), warehouse.getInventoryValue());
    }
}