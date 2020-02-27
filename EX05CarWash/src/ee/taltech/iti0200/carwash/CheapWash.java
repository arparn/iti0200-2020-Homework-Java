package ee.taltech.iti0200.carwash;

public class CheapWash extends WashStrategy {

    public static final int CAR_DIRTINESS_REDUCE = 40;
    public static final int WASH_AND_DRY_PRICE = 12;

    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionDuration(10);
        setSessionPrice(10);
        car.setDirtiness(car.getDirtiness() - CAR_DIRTINESS_REDUCE);
        owner.setBalance(owner.getBalance() - getWashPrice());
    }

    @Override
    public void dry(Car car, CarOwner owner) {
        setSessionDuration(getSessionDuration() + 1);
        setSessionPrice(getSessionPrice() + 2);
        owner.setBalance(owner.getBalance() - 2);
    }

    @Override
    public int getWashAndDryPrice() {
        return WASH_AND_DRY_PRICE;
    }

    @Override
    public int getWashPrice() {
        return 10;
    }
}
