
public class Archer extends Character {

    public Archer(String name) {
        super(name, 100, 10, 15);
    }

    @Override
    protected int getHealthIncrease() {
        return 15;
    }

    @Override
    public int useSpecialAbility() {

        int damage = (int) Math.round(
            getStrength() * 0.8 + getAgility() * 1.8
        );

        if (Math.random() < 0.35) {
            System.out.println("Critical hit!");
            damage *= 2;
        }

        return damage;
    }
}
