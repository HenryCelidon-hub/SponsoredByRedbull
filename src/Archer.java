
public class Archer extends Character {

    public Archer(String name) {
        super(name, 100, 10, 15);
    }

    @Override
    protected int getHealthIncrease() {
        return 15;
    }
}
