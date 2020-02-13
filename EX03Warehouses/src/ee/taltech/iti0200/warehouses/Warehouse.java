package ee.taltech.iti0200.warehouses;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Warehouse {
    private String address;
    private Map<Product, Long> inventory = new HashMap<>();
    private Set<Worker> workers = new HashSet<>();

    public Warehouse(String address) {
        this.address = address;
    }

    /**
     * Gets the amount of specified product in the warehouse.
     *
     * @param product the product
     * @return the amount
     */
    public Long getAmount(Product product) {
        return inventory.getOrDefault(product, (long) 0);
    }

    public String getAddress() {
        return address;
    }

    /**
     * Add product to warehouse inventory.
     *
     * @param productEntry the product entry
     */
    public void addProduct(Map.Entry<Product, Long> productEntry) {
        Product product = productEntry.getKey();
        Long amount = productEntry.getValue();
        Long value = inventory.getOrDefault(product, (long) 0) + amount;
        inventory.put(product, value);
    }

    /**
     * Checks if the warehouse contains the specified product.
     *
     * @param product the product to check
     * @return boolean that shows if the product exists in the warehouse
     */
    public boolean hasProduct(Product product) {
        return inventory.containsKey(product);
    }

    /**
     * Checks if the warehouse has enough of the specified product.
     *
     * @param product the product to check
     * @param amount the amount to check against
     * @return boolean that shows if there is enough product in the warehouse
     */
    public boolean hasEnoughProduct(Product product, Long amount) {
        return (hasProduct(product)) && getAmount(product) >= amount;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    /**
     * Add worker to the warehouse.
     *
     * @param worker the worker to add
     */
    public void addWorker(Worker worker) {
        if (!workers.contains(worker)) {
            workers.add(worker);
        }
    }

    /**
     * Gets warehouse inventory value.
     *
     * @return the inventory value
     */
    public BigDecimal getInventoryValue() {
        BigDecimal result = BigDecimal.ZERO;
        if (inventory.size() > 0) {
            for (Map.Entry<Product, Long> productEntry : inventory.entrySet()) {
                Product product = productEntry.getKey();
                Long value = productEntry.getValue();
                BigDecimal price = product.getNetPrice();
                BigDecimal amount = new BigDecimal(value);
                result = result.add(((amount.multiply(price))));
            }
            return result;
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(address, warehouse.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
