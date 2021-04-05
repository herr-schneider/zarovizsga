package hu.nive.ujratervezes.zarovizsga2.software;

public abstract class Software {

    protected String name;
    protected double price;

    public abstract void increasePrice();

    public Software() {
    }

    public Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
