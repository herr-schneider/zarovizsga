package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
     super.setHappiness(super.getHappiness() + 2);
    }

    @Override
    public void play(int hours) {
        super.setHappiness(super.getHappiness() + hours*2);
    }
}
