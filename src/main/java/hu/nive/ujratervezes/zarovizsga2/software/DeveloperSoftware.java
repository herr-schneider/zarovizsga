package hu.nive.ujratervezes.zarovizsga2.software;

public class DeveloperSoftware extends Software{

    public DeveloperSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        super.price = super.price * 1.10;
    }
}
