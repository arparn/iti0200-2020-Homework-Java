package ee.taltech.iti0200.carwash;

public class RegularWash extends WashStrategy {
    @Override
    public void wash(Car car, CarOwner owner) {
        setSessionPrice(30);
        setSessionDuration(15);
        car.setDirtiness(car.getDirtiness() - 70);
        owner.setBalance(owner.getBalance() - getWashPrice());
    }

    @Override
    public void dry(Car car, CarOwner owner) {
        setSessionDuration(20);
        setSessionPrice(5);
        owner.setBalance(owner.getBalance() - 5);
    }

    @Override
    public int getWashAndDryPrice() {
        return 35;
    }

    @Override
    public int getWashPrice() {
        return 30;
    }
}
