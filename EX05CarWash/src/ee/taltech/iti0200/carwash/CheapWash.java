package ee.taltech.iti0200.carwash;

public class CheapWash extends WashStrategy {
    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionDuration(10);
        setSessionPrice(10);
        car.setDirtiness(car.getDirtiness() - 40);
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
        return 12;
    }

    @Override
    public int getWashPrice() {
        return 10;
    }
}
