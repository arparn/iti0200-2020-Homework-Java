package ee.taltech.iti0200.warehouses;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
            for (Product example : products){
                cheapestPrice = example.getGrossPrice();
                cheapestProduct = example;
                break;
            }
            for (Product product : products) {
                BigDecimal price = product.getGrossPrice();
                if (price.compareTo(cheapestPrice) < 0) {
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
            for (Product example : products){
                expensivePrice = example.getGrossPrice();
                expensiveProduct = example;
                break;
            }
            for (Product product : products) {
                BigDecimal price = product.getGrossPrice();
                if (price.compareTo(expensivePrice) > 0) {
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
     * Reports the current state of products in the warehouses.
     *
     * @return the current state of products in the warehouses
     */
    public Map<Product, Long> reportInventory() {
        return null;
    }

    /**
     * Finds all warehouses where the product is available.
     *
     * @param product the product to check
     * @return list of warehouses where the product is availalble
     */
    public List<Warehouse> getAvailability(Product product) {
        return null;
    }

    /**
     * Adds specified amount of specified product to all warehouses.
     *
     * @param product the product to add
     * @param amount the amount of product to add
     */
    public void restockProduct(Product product, Long amount) {
    }

    /**
     * Add a new product to companies products list and all the warehouses of that company.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
    }

    /**
     * Gets all company workers.
     *
     * @return all company workers
     */
    public Set<Worker> getCompanyWorkers() {
        return null;
    }

    /**
     * Add an office worker.
     *
     * @param worker the worker to add
     */
    public void addOfficeWorker(Worker worker) {
    }

    public Set<Warehouse> getWarehouses() {
        return null;
    }

    /**
     * Add a warehouse.
     *
     * @param wareHouse the warehouse to add
     */
    public void addWarehouse(Warehouse wareHouse) {
    }

    /**
     * Gets total company goods value.
     *
     * @return total company goods value
     */
    public BigDecimal getCompanyGoodsValue() {
        return null;
    }
}