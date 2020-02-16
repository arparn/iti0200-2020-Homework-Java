package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Warehouse warehouse;
    Product product;
    Worker worker;
    Company company;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse("Akadeemia tee 7/1");
        product = new Product("Hoody", BigDecimal.ONE, BigDecimal.valueOf(100), BigDecimal.valueOf(150));
        worker = new Worker("Isac", "Clark", "50003103867", 75);
        company = new Company("Brazzers");
    }

    @Test
    void getName() {
        assertEquals("Brazzers", company.getName());
    }

    @Test
    void getCheapestProductForCustomer() {
        company.addProduct(product);
        assertEquals(Optional.of(product), company.getCheapestProductForCustomer());
    }

    @Test
    void getMostExpensiveProductForCustomer() {
        company.addProduct(product);
        assertEquals(Optional.of(product), company.getMostExpensiveProductForCustomer());
    }

    @Test
    void reportInventory() {
        HashMap<Product, Long> productMap = new HashMap<Product, Long>(Map.of(product, (long) 100));
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        company.addProduct(product);
        company.addWarehouse(warehouse);
        warehouse.addProduct(entry);
        assertEquals(productMap, company.reportInventory());
    }

    @Test
    void getAvailability() {
        LinkedList<Warehouse> warehouseList = new LinkedList<>();
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        warehouseList.add(warehouse);
        company.addProduct(product);
        company.addWarehouse(warehouse);
        warehouse.addProduct(entry);
        assertEquals(warehouseList, company.getAvailability(product));
    }

    @Test
    void restockProduct() {
        company.addWarehouse(warehouse);
        company.restockProduct(product, (long) 100);
        assertTrue(warehouse.hasEnoughProduct(product, (long) 100));
    }

    @Test
    void addProduct() {
        company.addWarehouse(warehouse);
        company.addProduct(product);
        assertTrue(warehouse.hasProduct(product));
    }

    @Test
    void getCompanyWorkers() {
        HashSet<Worker> workerSet = new HashSet<>();
        workerSet.add(worker);
        company.addWarehouse(warehouse);
        warehouse.addWorker(worker);
        assertEquals(workerSet, company.getCompanyWorkers());
    }

    @Test
    void addOfficeWorker() {
        HashSet<Worker> workerSet = new HashSet<>();
        workerSet.add(worker);
        company.addWarehouse(warehouse);
        company.addOfficeWorker(worker);
        assertEquals(workerSet, company.getCompanyWorkers());
    }

    @Test
    void getWarehouses() {
        company.addWarehouse(warehouse);
        HashSet<Warehouse> warehouseSet = new HashSet<>();
        warehouseSet.add(warehouse);
        assertEquals(warehouseSet, company.getWarehouses());
    }

    @Test
    void getCompanyGoodsValue() {
        Map.Entry<Product,Long> entry = new AbstractMap.SimpleEntry<Product, Long>(product, (long) 100);
        company.addWarehouse(warehouse);
        warehouse.addProduct(entry);
        BigDecimal value = new BigDecimal("10000");
        assertEquals(value, company.getCompanyGoodsValue());
    }
}