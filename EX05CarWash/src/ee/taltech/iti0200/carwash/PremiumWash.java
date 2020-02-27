package ee.taltech.iti0200.carwash;

public class PremiumWash extends WashStrategy {

    public static final int SESSION_PRICE = 60;
    public static final int SESSION_DURATION = 20;
    public static final int WASH_AND_DRY_PRICE = 70;

    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionPrice(SESSION_PRICE);
        setSessionDuration(SESSION_DURATION);
        car.setDirtiness(car.getDirtiness() - 100);
        owner.setBalance(owner.getBalance() - getWashPrice());
    }

    @Override
    public void dry(Car car, CarOwner owner) {
        setSessionDuration(getSessionDuration() + 10);
        setSessionPrice(getSessionPrice() + 10);
        owner.setBalance(owner.getBalance() - 10);
    }

    @Override
    public int getWashAndDryPrice() {
        return WASH_AND_DRY_PRICE;
    }

    @Override
    public int getWashPrice() {
        return SESSION_PRICE;
    }
}
