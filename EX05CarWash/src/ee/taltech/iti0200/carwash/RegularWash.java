package ee.taltech.iti0200.carwash;

public class RegularWash extends WashStrategy {

    public static final int SESSION_PRICE = 30;
    public static final int SESSION_DURATION = 15;
    public static final int CAR_DIRTINESS_REDUCE = 70;
    public static final int WASH_AND_DRY_PRICE = 35;

    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionPrice(SESSION_PRICE);
        setSessionDuration(SESSION_DURATION);
        car.setDirtiness(car.getDirtiness() - CAR_DIRTINESS_REDUCE);
        owner.setBalance(owner.getBalance() - getWashPrice());
    }

    @Override
    public void dry(Car car, CarOwner owner) {
        setSessionDuration(getSessionDuration() + 5);
        setSessionPrice(getSessionPrice() + 5);
        owner.setBalance(owner.getBalance() - 5);
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
