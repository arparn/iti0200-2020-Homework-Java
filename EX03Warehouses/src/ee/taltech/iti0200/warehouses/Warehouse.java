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
    }

    /**
     * Gets the amount of specified product in the warehouse.
     *
     * @param product the product
     * @return the amount
     */
    public Long getAmount(Product product) {
        return null;
    }

    public String getAddress() {
        return null;
    }

    /**
     * Add product to warehouse inventory.
     *
     * @param productEntry the product entry
     */
    public void addProduct(Map.Entry<Product, Long> productEntry) {
    }

    /**
     * Checks if the warehouse contains the specified product.
     *
     * @param product the product to check
     * @return boolean that shows if the product exists in the warehouse
     */
    public boolean hasProduct(Product product) {
        return false;
    }

    /**
     * Checks if the warehouse has enough of the specified product.
     *
     * @param product the product to check
     * @param amount the amount to check against
     * @return boolean that shows if there is enough product in the warehouse
     */
    public boolean hasEnoughProduct(Product product, Long amount) {
        return false;
    }

    public Set<Worker> getWorkers() {
        return null;
    }

    /**
     * Add worker to the warehouse.
     *
     * @param worker the worker to add
     */
    public void addWorker(Worker worker) {
    }

    /**
     * Gets warehouse inventory value.
     *
     * @return the inventory value
     */
    public BigDecimal getInventoryValue() {
        return null;
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