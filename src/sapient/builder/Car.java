package sapient.builder;

public class Car {

    public Car(CarBuilder builder) {
        this.type = builder.type;
        this.body = builder.body;
        this.wheels = builder.wheels;
        this.engine = builder.engine;
        this.nitro = builder.nitro;
        this.carbonHood = builder.carbonHood;
    }

    String type;
    String body;
    String wheels;
    String engine;

    //optionals
    String nitro;
    String carbonHood;



    public String getCarInfo() {
        return "Its a sedan";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EconomyCar{");
        sb.append("type=").append(type);
        sb.append(", body='").append(body).append('\'');
        sb.append(", wheels='").append(wheels).append('\'');
        sb.append(", engine='").append(engine).append('\'');
        sb.append(", nitro='").append(nitro).append('\'');
        sb.append(", carbonHood='").append(carbonHood).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
         Car car = new CarBuilder().setBody("Magnesium Body").setEngine("2000CC")
                .setType("SEDAN").setWheels("Alloy Wheels").setCarbonHood("Carbon Hood").build();

        System.out.println("car = " + car);
    }
}