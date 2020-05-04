package sapient.designPatterns.factory;

import java.util.InputMismatchException;

public class CarFactory {

    public static Car getCar(CarType type) {
        Car car;
        switch (type) {
            case SEDAN: {
                car = new Sedan();
                break;
            }
            case HATCHBACK: {
                car = new Hatchback();
                break;
            }
            default:
                throw new InputMismatchException("Invalid EconomyCar Type");
        }
        return car;
    }
}
