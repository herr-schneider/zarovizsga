package hu.nive.ujratervezes.zarovizsga2.software;

public class OfficeSoftware extends Software{

    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        super.price =  super.price * 1.05;
    }
}
