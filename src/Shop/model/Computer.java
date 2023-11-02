package Shop.model;
// найти компьютеры со скидкой на BlackFriday
public class Computer {

    // fields
    protected long barCode;
    protected String cpu;
    protected String brand;
    protected double price;

    // constructor
    public Computer(long barCode, String cpu, String brand, double price) {
        this.barCode = barCode;
        this.cpu = cpu;
        this.brand = brand;
        this.price = price;
    }

    // geteer and setter
    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "barCode=" + barCode +
                ", cpu='" + cpu + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Computer computer = (Computer) object;

        return barCode == computer.barCode;
    }

    @Override
    public int hashCode() {
        return (int) (barCode ^ (barCode >>> 32));
    }
}
