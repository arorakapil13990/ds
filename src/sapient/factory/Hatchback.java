package sapient.factory;

public class Hatchback implements Car {
    CarType type;

    public CarType getType() {
        return type;
    }

    public void setType(final CarType type) {
        this.type = type;
    }

    public String getCarInfo() {
        return "Its a hatchback";
    }
}
