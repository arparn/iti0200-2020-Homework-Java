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

    public static void main(String[] args) {
        CarOwner kai = new CarOwner("Kai", 72000);
        Car audi = new Car(5);
        CarOwner siim = new CarOwner("Siim", 1500);
        Car honda = new Car(80);
        CarOwner martin = new CarOwner("Martin", 0);
        Car bmw = new Car(100);

        CarWashService carWashService = new CarWashService();
        PremiumWash premiumWash = new PremiumWash();
        RegularWash regularWash = new RegularWash();
        CheapWash cheapWash = new CheapWash();

        System.out.println(carWashService.washAndDry(audi, kai));
        carWashService.setWashStrategy(premiumWash);
        System.out.println(carWashService.washAndDry(audi, kai));
        carWashService.setWashStrategy(regularWash);
        System.out.println(carWashService.wash(honda, siim));
        System.out.println(carWashService.washAndDry(honda, siim));
        carWashService.setWashStrategy(cheapWash);
        System.out.println(carWashService.washAndDry(bmw, martin));
    }

}