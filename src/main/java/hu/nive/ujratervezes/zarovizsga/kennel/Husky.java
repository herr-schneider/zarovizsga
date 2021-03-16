package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog{

    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        super.setHappiness(super.getHappiness() + 4);
    }

    @Override
    public void play(int hours) {
        super.setHappiness(super.getHappiness() + hours*3);
    }
}
