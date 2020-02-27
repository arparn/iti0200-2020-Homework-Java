package ee.taltech.iti0200.carwash;

public class PremiumWash extends WashStrategy {
    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionPrice(60);
        setSessionDuration(20);
        car.setDirtiness(car.getDirtiness() - 100);
        owner.setBalance(owner.getBalance() - getWashPrice());
    }

    @Override
    public void dry(Car car, CarOwner owner) {
        setSessionDuration(30);
        setSessionPrice(getSessionPrice() + 10);
        owner.setBalance(owner.getBalance() - 10);
    }

    @Override
    public int getWashAndDryPrice() {
        return 70;
    }

    @Override
    public int getWashPrice() {
        return 60;
    }
}
