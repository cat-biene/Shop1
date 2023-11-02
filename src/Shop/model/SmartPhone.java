package Shop.model;

public class SmartPhone extends Computer{

    public SmartPhone(long barCode, String cpu, String brand, double price) {
        super(barCode, cpu, brand, price);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "barCode=" + barCode +
                ", cpu='" + cpu + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
