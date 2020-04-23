package sapient.factory;

public class Demo {
    public static void main(String[] args) {
        Car sedan = CarFactory.getCar(CarType.SEDAN);
        System.out.println(sedan.getCarInfo());

        Car hatchback = CarFactory.getCar(CarType.HATCHBACK);
        System.out.println(hatchback.getCarInfo());
    }
}
