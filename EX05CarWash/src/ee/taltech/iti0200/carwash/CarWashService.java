package ee.taltech.iti0200.carwash;

public class CarWashService {
    private WashStrategy washStrategy;

    public void setWashStrategy(WashStrategy newWashStrategy) {
        washStrategy = newWashStrategy;
    }

    /**
     * Using provided WashStrategy to wash the owners car.
     *
     * @return the boolean if wash was successful
     */
    public boolean wash(Car car, CarOwner owner) {
        if (washStrategy == null) {
            return false;
        } else if (owner.getBalance() - washStrategy.getWashPrice() < 0) {
            return false;
        } else if (washStrategy.isClientBlacklisted(owner.getName())) {
            return false;
        } else {
            washStrategy.wash(car, owner);
            return true;
        }
    }

    /**
     * Using provided WashStrategy to wash and dry the owners car.
     *
     * @return the boolean if wash and dry was successful
     */
    public boolean washAndDry(Car car, CarOwner owner) {
        if (washStrategy == null) {
            return false;
        } else if (owner.getBalance() - washStrategy.getWashAndDryPrice() < 0) {
            return false;
        } else if (washStrategy.isClientBlacklisted(owner.getName())) {
            return false;
        } else {
            washStrategy.wash(car, owner);
            washStrategy.dry(car, owner);
            return true;
        }
    }
}
