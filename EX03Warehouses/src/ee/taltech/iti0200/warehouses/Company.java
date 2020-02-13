package ee.taltech.iti0200.warehouses;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Company {
    private String name;
    private Set<Warehouse> warehouses = new HashSet<>();
    private Set<Worker> officeWorkers = new HashSet<>();
    private Set<Product> products = new HashSet<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Gets the cheapest product for customer.
     *
     * @return the cheapest product
     */
    public Optional<Product> getCheapestProductForCustomer() {
        if (products.size() > 0) {
            BigDecimal cheapestPrice = BigDecimal.ZERO;
            Product cheapestProduct = null;
            for (Product product : products) {
                BigDecimal price = product.getGrossPrice();
                if (cheapestProduct == null || price.compareTo(cheapestPrice) < 0) {
                    cheapestPrice = price;
                    cheapestProduct = product;
                }
            }
            return Optional.of(cheapestProduct);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Gets the most expensive product for customer.
     *
     * @return the most expensive product
     */
    public Optional<Product> getMostExpensiveProductForCustomer() {
        if (products.size() > 0) {
            BigDecimal expensivePrice = BigDecimal.ZERO;
            Product expensiveProduct = null;
            for (Product product : products) {
                BigDecimal price = product.getGrossPrice();
                if (expensiveProduct == null || price.compareTo(expensivePrice) > 0) {
                    expensivePrice = price;
                    expensiveProduct = product;
                }
            }
            return Optional.of(expensiveProduct);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Reports the current state of products in the warehouses
     *
     * @return the current state of products in the warehouses
     */
    public Map<Product, Long> reportInventory() {
        HashMap<Product, Long> inventoryMap = new HashMap<>();
        Long amount;
        for (Product product : products) {
            for (Warehouse warehouse : warehouses) {
                if (warehouse.hasProduct(product)) {
                    if (!inventoryMap.containsKey(product)) {
                        amount = (long) 0;
                    } else {
                        amount = inventoryMap.get(product);
                    }
                    Long value = warehouse.getAmount(product);
                    inventoryMap.put(product, value + amount);
                }
            }
        }
        return inventoryMap;
    }

    /**
     * Finds all warehouses where the product is available.
     *
     * @param product the product to check
     * @return list of warehouses where the product is availalble
     */
    public List<Warehouse> getAvailability(Product product) {
        LinkedList<Warehouse> availabilityList = new LinkedList<>();
        for (Warehouse warehouse : warehouses) {
            if (warehouse.hasProduct(product)) {
                availabilityList.add(warehouse);
            }
        }
        return availabilityList;
    }

    /**
     * Adds specified amount of specified product to all warehouses.
     *
     * @param product the product to add
     * @param amount the amount of product to add
     */
    public void restockProduct(Product product, Long amount) {
        Map.Entry<Product, Long> productEntry = Map.entry(product, amount);
        for (Warehouse warehouse : warehouses) {
            warehouse.addProduct(productEntry);
        }
    }

    /**
     * Add a new product to companies products list and all the warehouses of that company.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.add(product);
        Long amount = (long) 0;
        Map.Entry<Product, Long> productEntry = Map.entry(product, amount);
        for (Warehouse warehouse : warehouses) {
            warehouse.addProduct(productEntry);
        }
    }

    /**
     * Gets all company workers.
     *
     * @return all company workers
     */
    public Set<Worker> getCompanyWorkers() {
        Set<Worker> workers = officeWorkers;
        for (Warehouse warehouse : warehouses) {
            Set<Worker> warehouseWorkers = warehouse.getWorkers();
            workers.addAll(warehouseWorkers);
        }
        return workers;
    }

    /**
     * Add an office worker.
     *
     * @param worker the worker to add
     */
    public void addOfficeWorker(Worker worker) {
        if (!officeWorkers.contains(worker)) {
            officeWorkers.add(worker);
        }
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    /**
     * Add a warehouse.
     *
     * @param wareHouse the warehouse to add
     */
    public void addWarehouse(Warehouse wareHouse) {
        if (!warehouses.contains(wareHouse)) {
            warehouses.add(wareHouse);
        }
    }

    /**
     * Gets total company goods value.
     *
     * @return total company goods value
     */
    public BigDecimal getCompanyGoodsValue() {
        BigDecimal result = BigDecimal.ZERO;
        for (Warehouse warehouse : warehouses) {
            result = result.add(warehouse.getInventoryValue());
        }
        return result;
    }
}
